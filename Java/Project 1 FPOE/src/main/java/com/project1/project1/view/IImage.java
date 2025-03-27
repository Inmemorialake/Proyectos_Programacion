package com.project1.project1.view;

/**
 * @autor: Inmemorialake (2416541)
 */

// Imports
import javafx.scene.control.Label;
import javafx.scene.image.Image;

/**
 * Interface that represents the image of the game
 */
public interface IImage {
    /** @param image An Image to show  */
    public void showImage(Image image);
    /** @param image An Image to show
     *  @param label The label where the image is allocated
     */
    public void showImage(Label label,Image image);
}
