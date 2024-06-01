//package agh.ics.oop.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TextMap implements WorldMap<String, Integer> {
//    private final List<String> texts = new ArrayList<>();
//
//    @Override
//    public boolean place(String text) {
//        return texts.add(text);
//    }
//
//    @Override
//    public void move(String text, MoveDirection direction) {
//        int index = texts.indexOf(text);
//
//        if (index == -1) return;
//
//        switch (direction) {
//            case FORWARD:
//                if (index < texts.size() - 1) {
//                    texts.set(index, texts.get(index + 1));
//                    texts.set(index + 1, text);
//                }
//                break;
//            case BACKWARD:
//                if (index > 0) {
//                    texts.set(index, texts.get(index - 1));
//                    texts.set(index - 1, text);
//                }
//                break;
//            default:
//                break;
//        }
//    }
//
//    @Override
//    public boolean isOccupied(Integer position) {
//        return position >= 0 && position < texts.size();
//    }
//
//    @Override
//    public WorldElement objectAt(Integer position) {
//        if (isOccupied(position)) {
//            return texts.get(position);
//        }
//        return null;
//    }
//
//    @Override
//    public boolean canMoveTo(Integer position) {
//        return position >= 0 && position <= texts.size();
//    }
//
//    @Override
//    public String toString() {
//        return texts.toString();
//    }
//}
