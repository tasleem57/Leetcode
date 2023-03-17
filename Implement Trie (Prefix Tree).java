class Trie {
    HashSet<String> hs;
    public Trie() {
        hs=new HashSet<>();
    }
    
    public void insert(String word) {
        hs.add(word);
    }
    
    public boolean search(String word) {
        if(hs.contains(word))
            return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        for(String it:hs){
            if(it.startsWith(prefix))
                return true;
        }
        return false;
    }
}
