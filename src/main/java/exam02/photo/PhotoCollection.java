package exam02.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {

    private final List<Photo> photos = new ArrayList<>();

    public void addPhoto(String... names) {
        if (names == null || names.length == 0) {
            throw new IllegalArgumentException("Photo must not be null or empty");
        }
        for (String name : names) {
            this.photos.add(new Photo(name));
        }
    }

    public List<Photo> getPhotos() {
        return new ArrayList<>(photos);
    }

    public void starPhoto(String name, Quality star) {
        for (Photo photo : photos) {
            if (name.equals(photo.getName())) {
                photo.setQuality(star);
                return;
            }
        }
        throw new PhotoNotFoundException();
    }

    public int numberOfStars() {
        int sum = 0;

        for (Photo photo : photos) {
            switch (photo.getQuality()) {
                case ONE_STAR -> sum++;
                case TWO_STAR -> sum += 2;
            }
        }

        return sum;
    }
}
