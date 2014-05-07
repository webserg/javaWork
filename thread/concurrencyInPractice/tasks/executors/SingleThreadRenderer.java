package thread.concurrencyInPractice.tasks.executors;

import java.util.ArrayList;
import java.util.List;

/**
 * A less annoying but still sequential approach involves rendering the text elements first, leaving
 * rectangular placeholders for the images, and after completing the initial pass on the document,
 * going back and downloading the images and drawing them into the associated placeholder.
 * 
 * @author Sergiy Doroshenko 
 * Feb 17, 2009 10:58:11 PM
 */
public class SingleThreadRenderer {
    void renderPage(CharSequence source) {
	Action.renderText(source);
	List<ImageData> imageData = new ArrayList<ImageData>();
	for (ImageInfo imageInfo : Action.scanForImageInfo(source))
	    imageData.add(imageInfo.downloadImage());
	for (ImageData data : imageData)
	    Action.renderImage(data);
    }

}
