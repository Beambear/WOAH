package examTep;

public class GenericItem <T>{
    private T t;
    private int x;
    private int y;
    public void set(T t){
        this.t = t;

    }
    public T get(){
        return t;
    }

    public boolean isOut(){
        if(x<=-500){
            return true;
        }
        return false;
    }
}

public class Bullet{
    private String imagePath;
    private int x;
    private int y;
    private Bullet(String path, int x , int y){
        this.imagePath = path;
        this.x = x;
        this.y =y;
    }
    public void setX(int x){
        this.x =x;
    }
    public int getX(){
        return x;
    }
}

public class background{
    private String image;
    private int x;
    private int y;
    private background(){

    }
    public void setX(int x){
        this.x =x;
    }
    public int getX(){
        return x;
    }
}

public class TestRun{
    GenericItem<Bullet> bullet01 = new GenericItem<Bullet>();
    bullet01.set(new Bullet("img",-400,500));
    if(bullet01.isOut()==true){
        delete();
    };

    GenericItem<Bullet> background = new GenericItem<background>();
    background.set(new Background("img",-600,200));
    if(background.isOut()==true){
        delete();
    }

}