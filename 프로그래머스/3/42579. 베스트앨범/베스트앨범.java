import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<Song> songs = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            songs.add(new Song(i, plays[i], genres[i]));
        }
        
        List<String> genreList = new ArrayList<>(map.keySet());
        Collections.sort(genreList, (a, b) -> map.get(b) - map.get(a));
        
        List<Integer> result = new ArrayList<>();
        for (String genre : genreList) {
            List<Song> temp = new ArrayList<>();
            for (Song s : songs) {
                if (s.genre.equals(genre)) {
                    temp.add(s);  
                }
            }
            
            Collections.sort(temp, (a, b) -> {
                if (a.play == b.play) {
                    return a.idx - b.idx;
                }
                return b.play - a.play;
            });
            
            for (int i = 0; i < 2; i++) {
                if (temp.size() - 1 < i) break;
                
                result.add(temp.get(i).idx);
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    class Song {
        int idx;
        int play;
        String genre;
        
        Song(int idx, int play, String genre) {
            this.idx = idx;
            this.play = play;
            this.genre = genre;
        }
    }
}