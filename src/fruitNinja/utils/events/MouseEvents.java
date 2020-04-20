package fruitNinja.utils.events;

import fruitNinja.animations.Projectile;
import fruitNinja.models.fruits.Fruit;
import fruitNinja.models.gameObjects.Sprite;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.HashMap;

public class MouseEvents implements EventHandler<MouseEvent> {

    private HashMap<Sprite, Projectile> spritesMap;
    public MouseEvents(HashMap<Sprite, Projectile> spritesMap)
    {
        this.spritesMap = spritesMap;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        double mouseX = mouseEvent.getX();
        double mouseY = mouseEvent.getY();

        spritesMap.forEach((k,v) -> {
            if (k.intersect(mouseX, mouseY) && !k.isSliced())
                k.slice();
        });
    }
}