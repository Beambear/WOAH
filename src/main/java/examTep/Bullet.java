package examTep;

public class Bullet extends  FlyObjects{

    int damage;
    public Bullet(String img, int x, int y) {
        super(img, x, y);
    }

    @Override
    public void hitPlayer(Player player) {
        player.getDamage( damage );
    }
}

public class weaponBox extends  FlyObjects{

    String weaponCode;
    public weaponBox(String img, int x, int y) {
        super(img, x, y);
    }

    @Override
    public void hitPlayer(Player player) {
        player.getWeapon( weaponCode );
    }
}