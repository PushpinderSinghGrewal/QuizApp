package quiz;

import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.text.PDFTextStripper;
//import org.apache.pdfbox.text.TextPosition;
 
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.util.PDFTextStripper;
 import org.apache.pdfbox.util.TextPosition;
/**
 * This is an example on how to extract words from PDF document
 */
 class Quiz extends PDFTextStripper {
    public static int counter=0;
   public static int questionNo=1;
   public static int questionNoForOption=1;
   public static int countero=0;
   public static int optionNo=1;
   public static int countera=20;
   public static  String[] ans=new String[40];
    @Override
    protected void endArticle() throws IOException {
        super.endArticle(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    static List<String> words = new ArrayList<String>();
 
    public Quiz() throws IOException {}
 
    public  static void getQuestion() throws IOException
 {          
   PDDocument document = null;
   String fileName = "C:/users/pinder/desktop/edited_Quiz.pdf"; // replace with your PDF file name
   try {
         document = PDDocument.load( new File(fileName) );
         PDFTextStripper stripper = new Quiz();
         stripper.setSortByPosition( true );
         stripper.setStartPage( 0);
         stripper.setEndPage( 4 );
         Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
         stripper.writeText(document, dummy);
              
        
         String text=""; 
         while( true)
         {
           String word=words.get(counter);
                
           if(word.startsWith(Integer.toString(questionNo)))
           { 
             do
             { text=text+words.get(counter)+" ";
               counter++;
                        
             }while(!(words.get(counter).equals("A.")));
             System.out.println(text);
             System.out.println("question no is"+questionNo);
             Mainpage.jLabel1.setText(text);
             break;
           }
          counter++;;     
                
          }
        questionNo++;
        }
        finally {
            if( document != null ) {
                document.close();
            }
        }
     
 }
 public static void getOptions ()throws IOException
 {PDDocument document = null;
   String fileName = "C:\\Users\\Pinder\\Documents\\NetBeansProjects\\Quiz\\src\\quiz\\edited_quiz.pdf"; // replace with your PDF file name
   try {
         document = PDDocument.load( new File(fileName) );
         PDFTextStripper stripper = new Quiz();
         stripper.setSortByPosition( true );
         stripper.setStartPage( 0);
         stripper.setEndPage( 4 );
         Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
         stripper.writeText(document, dummy);
              
          
         String option1=""; 
         String option2="";
         String option3="";
         String option4="";
         while( true)
         {
           String word=words.get(countero);
                 
           
               if(word.startsWith("A."))
                       {
                           while(!(words.get(countero).equals("B.")))
                           {option1=option1+words.get(countero)+" ";
               countero++;}
                      System.out.println(option1);
            
             Mainpage.jRadioButton1.setText("<html>"+option1+"</html>"); 
            
                    
         
                       }
             if(words.get(countero).equals("B."))
                       {    
                           while(!(words.get(countero).equals("C.")))
             { option2=option2+words.get(countero)+" ";
               countero++;
                        
             }
                      System.out.println(option2);
            
             Mainpage.jRadioButton2.setText("<html>"+option2+"</html>"); 
                       }
                if(words.get(countero).equals("C."))
                       {    
                           while(!(words.get(countero).equals("D.")))
             { option3=option3+words.get(countero)+" ";
               countero++;
                        
             }
                           System.out.println(option3);
                            Mainpage.jRadioButton3.setText("<html>"+option3+"</html>"); 
                       }   
                           if(words.get(countero).equals("D."))
                       {   //for(int i=0;i<3;i++)
                       while(!(words.get(countero).equals(".")))
                           {
                           option4=option4+words.get(countero)+" ";
                           countero++;
                       }  
                      // System.out.println("Question no. is "+questionNo);
                      System.out.println(option4);
            
             Mainpage.jRadioButton4.setText("<html>"+option4+"</html>"); 
                       break;}
             countero++;  
           }
            
               
          }
       
 
        finally {
            if( document != null ) {
                document.close();
            }
                }       }
 
 
 
 
 
 
 
 
 
 public static void getAnswer() throws IOException
 {
 
 PDDocument documents = null;
   String fileName = "C:/users/pinder/desktop/edited_Quiz.pdf"; // replace with your PDF file name
   try {
         documents = PDDocument.load( new File(fileName) );
         PDFTextStripper stripper = new Quiz();
         stripper.setSortByPosition( true );
         stripper.setStartPage(5);
         stripper.setEndPage(8);
         Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
         stripper.writeText(documents, dummy);
        System.err.println( "yo");
        String word;
           
        while(!(words.get(countera).equals("Answers")))
        {      //int countera=0;
             countera++;
            
       
           
        }
      countera++;
               for(int i=0;i<40;i++)
                   { word=words.get(countera);
                   if((word.startsWith(Integer.toString(i+1))))
                   {countera++;
                   ans[i]=words.get(countera);
                   }
                  
            // x=0;
//             System.out.println(ans[i]);
             countera++;
               }
   } finally {
            if( documents != null ) {
                documents.close();
            }
 }
 }   /**
     * @throws IOException If there is an error parsing the document.
     */
    public static void main( String[] args ) throws IOException    {
      /*  PDDocument document = null;
        String fileName = "C:/users/pinder/desktop/Quiz.pdf"; // replace with your PDF file name
        try {
            document = PDDocument.load( new File(fileName) );
            PDFTextStripper stripper = new Quiz();
            stripper.setSortByPosition( true );
            stripper.setStartPage( 0 );
            stripper.setEndPage( document.getNumberOfPages() );
 
            Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
            stripper.writeText(document, dummy);
        */   //getQuestion();
            // print words
         /*   for(String word:words){
                           
                //  if(word.equals("A."))
                System.out.println(word);                
            }*/
        }
        //finally {
          //  if( document != null ) {
            //    document.close();
            //}
        
    
 
    /**
     * Override the default functionality of PDFTextStripper.writeString()
     */
    @Override
    protected void writeString(String str, List<TextPosition> textPositions) throws IOException {
        String[] wordsInStream = str.split(getWordSeparator());
        if(wordsInStream!=null){
            for(String word :wordsInStream){
                words.add(word);
            }
        }
    }
}
