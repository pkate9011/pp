import java.io.*;
class FileWatcher extends Thread
{
    String filename;
    int count = 0,countBuffer=0,countLine=0;
    String lineNumber = "";
    BufferedReader br;
    String inputSearch;
    String line = "";
    FileWatcher(String filename,String srch)
    {
        this.filename = filename;
        inputSearch = srch;
    }
    public void run()
    {
        try
        {
            try
            {
                br = new BufferedReader(new FileReader("/home/mansi/"+filename));
                try
                {
                    while ((line = br.readLine()) != null)
                    {
                        countLine++;
                        //System.out.println(line);
                        String[] words = line.split(" ");
                        for (String word : words)
                        {
                            if (word.equals(inputSearch))
                            {
                                count++;
                                countBuffer++;
                            }
                        }
                        if (countBuffer > 0)
                        {
                            countBuffer = 0;
                            lineNumber += countLine + ",";
                        }
                    }
                    br.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            System.out.println("\n Thread Name = "+this+"\n File Name = "+filename+"\n Times found at = "+count+"\n Word found at = "+lineNumber);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
class Slip14_a
{
    public static void main(String args[])
    {
        int i;
        File fl;
        File dir = new File("/home/mansi");
        String files[] = dir.list();
        FileWatcher fw[] = new FileWatcher[files.length];
        for(i=0; i<files.length; i++)
        {
            if(files[i].endsWith(".txt"))
            {
                fw[i] = new FileWatcher(files[i],args[0]);
                fw[i].start();
            }
        }
    }
}