package main;
//------------------------------------------------------------------------
//	Author: Jipeng Liu
//
//
// 	Class: Item
// 	Description:
//		This class is an object class.
//      Items can provide various functions, items stored in inventory.
//      player press W to use current selected item.
//      Contains 5 attributes
//      Contains working logic methods and getters and setters.
//
public class Item {
    String itemCode;
    public Item(){};
//////////////////////////////////////////////////////////
//	Constructor for item                                //
//	Input	: String itemCode                   		//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public Item(String itemCode){
        this.itemCode = itemCode;
    }

//////////////////////////////////////////////////////////
//	use current item, implement affects on player       //
//	depends on itemCode                                 //
//	Input	: Player player         					//
//	Output	: None										//
//////////////////////////////////////////////////////////
    public void useItem(Player player){
        switch(itemCode){
            case "item01":
                 speedUp(player);
                 break;
            case "item02":
                 blink(player);
                 break;
            default:
                System.out.println("Failed: wrong item code");
        }
    }

//////////////////////////////////////////////////////////
//	Item01 working logic, make player speed up for 5s   //
//	then back to previous speed                         //
//	Input	: Player player     						//
//	Output	: None										//
//////////////////////////////////////////////////////////
    private void speedUp(Player player){
        player.setMoveSpeed(player.getMoveSpeed()+5);
        new Thread(() -> {
            try {
                Thread.sleep(5000); //decrease speed to normal in 5 seconds.
                player.setMoveSpeed(player.getMoveSpeed()-5);
                System.out.println("player_move_speed: "+(player.getMoveSpeed()+5)+" -> "+player.getMoveSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

//////////////////////////////////////////////////////////
//	Item02 working logic, player blink certain distance //
//  in current moving direction                         //
//	Input	: Player player     						//
//	Output	: None										//
//////////////////////////////////////////////////////////
    private void blink(Player player){
        boolean up = player.isUp();
        boolean down = player.isDown();
        boolean left = player.isLeft();
        boolean right = player.isRight();
        int blinkRange = 200;
        if(up&&!down&&!left&&!right){       //up
            player.playerLocationY-=blinkRange;
        }else if(!up&&down&&!left&&!right){ //down
            player.playerLocationY+=blinkRange;
        }else if(!up&&!down&&left&&!right){ //left
            player.playerLocationX-=blinkRange;
        }else if(!up&&!down&&!left&&right){ //right
            player.playerLocationX+=blinkRange;
        }else if(up&&!down&&!left&&right){  //up & right
            player.playerLocationX+=blinkRange;
            player.playerLocationY-=blinkRange;
        }else if(up&&!down&&left&&!right){ //up & left
            player.playerLocationX-=blinkRange;
            player.playerLocationY-=blinkRange;
        }else if(!up&&down&&!left&&right){ //down & right
            player.playerLocationX+=blinkRange;
            player.playerLocationY+=blinkRange;
        }else if(!up&&down&&left&&!right){ //down & left
            player.playerLocationX-=blinkRange;
            player.playerLocationY+=blinkRange;
        }

    }
}
