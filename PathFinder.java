import java.io.File;

public class PathFinder {
    public static void main(String[] args) {
        if(args.length != 2){       //Checks if the right amount of arguments is placed into the command line
            System.out.println("Incorrect number of arguments. Please provide the folder as the first argument, and the file as the second");
            System.exit(-1);        //Terminates the program, -1 signalling it terminated unsucesfully
        }

        String folderInput = args[0];   //Saving the inputs as strings for easier use
        String fileInput = args[1];
        File myDirectory = new File(folderInput);   //Creating a new file wth our argument path as the argument

        search(myDirectory, fileInput);     //The recursive call

    }

    //The recursive method, the work horse of the code
    public static void search(File folder, String filename){
        //The base case, will occur when there aren't anymore subfolders to explore
        if(!folder.isDirectory()){
            return;
        }

        File[] files = folder.listFiles();    //Splitting up the current folder into an array of all things within that folder
        for(int i = 0; i < files.length; i++){
            if(!files[i].isDirectory()){        //If this is not a directory, we might as well check if its our file right?
                if(files[i].getName().contains(filename)){
                    System.out.println("Found " + files[i].getAbsolutePath());      //Prints out the path of the file, using the file classes  methods
                }
                else{
                    //Do nothing, this is just so we can connect this else statement with the last if. I was too lazy to restucture the code lol
                }
            }
            else{
                search(files[i], filename);     //If it is a directory, we will recursivly call a the method, searching throught this subfolder
            }
        }
    }
}