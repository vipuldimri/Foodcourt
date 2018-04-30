package DataStructures;
import java.util.ArrayList;
public class Trie 
{
    Node start ;
    public Trie()
    {
      start = new Node();
      start.char_data = '\0';
      
    }
  
    public void addWord(String word)
    {
      addWord(word,start);
    }
  
    private void addWord(String word,Node current)
    {
		
      if(word.length() == 0)
      {
        current.isTerminating = true ;
        return ;
      }
      
      char currentchar = word.charAt(0);
      if(currentchar == ' ' )
      {
          if(current.children.get(27)==null)
          {
                Node newnode = new Node();
        newnode.char_data = ' ';
        current.children.set(27,newnode);
        addWord(word.substring(1),current.children.get(27));
          }else{
              addWord(word.substring(1),current.children.get(27));
          }
      
      
      }else{
              int index =  currentchar - 97;
      if(current.children.get(index) == null)
      {
        
        Node newnode = new Node();
        newnode.char_data = currentchar ;
        current.children.set(index,newnode);
        addWord(word.substring(1),current.children.get(index));
      }
      else
      {
            addWord(word.substring(1),current.children.get(index));
      }
      }
  
      
      
	}
	// Here Add method Finished
  
    public boolean search(String word)
    {
      
      return search(word,start);
      
    }
     private  boolean search(String word ,Node current)
	{
		
      if(word.length() == 0)
      {
        if(current.isTerminating == true )
          return true ;
        else
        return false ;
      }
      boolean ans = false ;
      char currentchar = word.charAt(0);
      int index =  currentchar - 97;
      if(current.children.get(index) == null)
      {
        return false;
       
      }else
      {
      ans =   search(word.substring(1),current.children.get(index));
      }
      
      return ans;
	}
	
    // Search Method Ends here
    public ArrayList<String> AutoComplete(String word,ArrayList<String> list)
    {
      if(word.length()==0 )
      {
          return list ;
      }
      
      return AutoComplete(word,start,word,list);
    }
    private ArrayList<String>  AutoComplete(String word , Node current,String ans,ArrayList<String> list)
    {
      
      if(word.length() == 0)
      {
        AutoCompleteHelper(current,ans.substring(0,ans.length()-1),list);
        return list;
      }
      char currentchar = word.charAt(0);
      if(currentchar == ' ')
      {
           if(current.children.get(27) == null)
           {
           return list;
       
           }else
           {
            return  AutoComplete(word.substring(1),current.children.get(27),ans,list);
            }
          
      }else{
              
      int index =  currentchar - 97;
      if(current.children.get(index) == null)
      {
        return list;
       
      }else
      {
       return  AutoComplete(word.substring(1),current.children.get(index),ans,list);
      }
              }
   
      
      
    }
    private ArrayList<String> AutoCompleteHelper(Node current ,String ans,ArrayList<String> list)
    {
      if(current.isTerminating == true )
      {
        //System.out.println(ans +current.char_data);
          list.add(ans +current.char_data);
      }
      
      
    for(int i =0 ;i < 28 ;i++)
    {
      if(current.children.get(i) != null)
      {
         AutoCompleteHelper(current.children.get(i) ,ans +current.char_data,list);
      }
      
    }

      return list;
      
    }
    // AutoComplete Ends Here	

  
}
