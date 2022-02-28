import java.util.LinkedHashMap;
import java.util.Scanner;

public class Task03 {

    public static class Followers {
        String name;
        int likes;
        int comments;

        public Followers(String name, int likes, int comments) {
            this.name = name;
            this.likes = likes;
            this.comments = comments;
        }

        public void setComments(int comments) {
            this.comments = comments;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public int getComments() {
            return comments;
        }

        public int getLikes() {
            return likes;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, Followers> followers = new LinkedHashMap<String, Followers>();

        String input = scan.nextLine();
        while (!input.equals("Log out")) {
            String[] tokens = input.split("\\: ");
            String user = tokens[1];
            switch (tokens[0]) {
                case "New follower":
                    followers.putIfAbsent(user, new Followers(user, 0, 0));
                    break;
                case "Like":
                    int likes = Integer.parseInt(tokens[2]);
                    if (followers.containsKey(user)) {
                        followers.get(user).setLikes(followers.get(user).getLikes() + likes);
                    } else {
                        followers.put(user, new Followers(user, likes, 0));
                    }
                    break;
                case "Comment":
                    if (followers.containsKey(user)) {
                        followers.get(user).setComments(followers.get(user).getComments() + 1);
                    } else {
                        followers.put(user, new Followers(user, 0, 1));
                    }
                    break;
                case "Blocked":
                    if (followers.containsKey(user)) {
                        followers.remove(user);
                    } else {
                        System.out.println(user + " doesn't exist.");
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println(followers.size() + " followers");
        followers.values()
                .stream()
                .sorted((a, b) -> {
                    int result = b.getComments() + b.getLikes() - (a.getComments() + a.getLikes());
                    if (result == 0) {
                        result = a.getName().compareTo(b.getName());
                    }
                    return result;
                }).forEach(x -> System.out.println(x.getName() + ": " + (x.getLikes() + x.getComments())));
    }
}
