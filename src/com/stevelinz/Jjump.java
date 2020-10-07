package com.stevelinz;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Jjump {

    public static void main(String[] args) throws IOException {

        JOptionPane.showMessageDialog(null, "" +
            "For Log files with timestamps '00:00:00'   " + "\n" +
            "this program determines time jumps." +     "\n" +
            "Browse to the log file.                    " + "\n\n" +
            "Select where to save the results report    " + "\n" +
            "support@mekorma.com 2020                   " + "\n" +
            "LOG FILE TESTING                           " + "\n" +
            "LOG JUMP REPORT                            ");

        JFileChooser fileChooser = new JFileChooser();

        int status = fileChooser.showOpenDialog(null);

        FileReader file = new FileReader(fileChooser.getSelectedFile());
        BufferedReader inputFile = new BufferedReader(file);

        List<String> fList = new ArrayList<String>();
        String listNew;


        if (status == JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null,
                    "Select a file name for the        " + "\n" +
                            "Mekorma Dex. Log Jump Report.     " + "\n" +
                            "(*.txt extension will be added)   " + "\n" +
                            "Thank you for using this Utility. ");
        }
        int option = fileChooser.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            File fileS = fileChooser.getSelectedFile();
            String filenameS = fileS.getPath();
            JOptionPane.showMessageDialog(null, "Saved: " + filenameS + ".txt");
            FileWriter outFile = new FileWriter(fileS + ".txt");

            outFile.write("Mekorma Log Jump Report");
            outFile.write("\n");

            while ((listNew = inputFile.readLine()) != null)
            {
                fList.add(listNew);
            }
            for (int i = 1; i < fList.size() ; i++) {
                if (fList.get(i).charAt(7) != fList.get(i - 1).charAt(7)) {
                    outFile.write(fList.get(i));
                    outFile.write("\n");
                }
            }
            outFile.write("End of Jump Report");
            outFile.write("\n\n");
            /////////////new////////////////////
            for (int i = 1; i < fList.size() ; i++) {
                if(fList.get(i).contains("ME_Get_Dict_Path")
                        ||fList.get(i).contains("SQLPath', 5261, 7, 22000")
                        ||fList.get(i).contains("Main_WIN_ACT on form MPP")
                        ||fList.get(i).contains("ListCommands_FindListID() of form Main Menu', 0, 2404")
                        ||fList.get(i).contains("DoesBatchNeedApproval() of form meThresholdObj")
                        ||fList.get(i).contains("DDL_Bins_CHG on form MPP_Company_Setup")
                        ||fList.get(i).contains("Switch Company l_Company Names_CHG")){
                    outFile.write(fList.get(i));
                    outFile.write("\n");
                }
            }
            ///////////////////////////////////////
            outFile.write("End of entire Mekorma Log Report");
            inputFile.close();
            outFile.flush();
            outFile.close();
        }

    }

}









