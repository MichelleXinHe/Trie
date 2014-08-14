public class Anagrams {
    //Trie
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result=new ArrayList<String>();
        if(strs==null||strs.length==0) return result;
        TrieTree tree=new TrieTree();
        for(int i=0; i<strs.length; i++){
            char[] c=strs[i].toCharArray();
            Arrays.sort(c);
            String temp=new String(c);
            tree.insert(temp, i);
        }
        
        ArrayList<Integer> indexes=tree.search();
        for(int i:indexes){
            result.add(strs[i]);
        }
        return result;
    }    
}

//create Trie tree
//the leaf nodes will contains the index of the string end at this leaf
class TrieTree{
    TrieNode root;
    public TrieTree(){
        root=new TrieNode();
    }
    
    public void insert(String s, int index){
        root.insert(s, index);
    }
    
    public ArrayList<Integer> search(){
        return root.search();
    }
}

class TrieNode{
    HashMap<Character, TrieNode> children;
    char val;
    ArrayList<Integer> indexes;
    public TrieNode(){
        children=new HashMap<Character, TrieNode>();
        indexes=new ArrayList<Integer>();
    }
    
    public void insert(String s, int index){
        if(s==null) return;
        if(s.length()==0){
            indexes.add(index);
            return;
        }
        
        val=s.charAt(0);
        TrieNode child=null;
        if(children.containsKey(val)){
            child=children.get(val);
        }else{
            child=new TrieNode();
        }
        
        child.insert(s.substring(1), index);
        children.put(val, child);
    }
    
    public ArrayList<Integer> search(){
        ArrayList<Integer> result=new ArrayList<Integer>();
        //only if more than 1 words end at this node, they are anagrams
        if(indexes.size()>1) result.addAll(indexes);
        Set<Character> keys=children.keySet();
        for(char key:keys){
            TrieNode child=children.get(key);
            result.addAll(child.search());
        }
        
        return result;
    }
}
