/* Class: CISC 3130
 * Section: TY9
 * EmplId: 23450441
 * Name: Tengiz Sanadze
 */

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileWriter;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.Arrays;

import java.util.Scanner;

public class RPD {

   public static void main(String args[] ) throws Exception {

       TrackData w = new TrackData();

       w.readFile(); //read file and store data

       w.reportArtists();  //print repost of artist to file

   }

}

/*

* this class represents array structure of data in file in terms of rows and columns

*/

class TrackData{

   int cols;

   int rows;

   String[][] data;

  

//Constructor for trackdata class

   public TrackData(){

       this.cols = 5;

       this.rows = 10;

       this.data = new String[rows][cols];

   }

   /*

   * Read file contents into data array

   */

   public void readFile(){

       File text = new File(""); //open file

       Scanner scnr; //read using scanner

       try {

           scnr = new Scanner(text);

           int row =0, col=0;

           while(scnr.hasNextLine()){  //check next line exist

       String line = scnr.nextLine();  //read and forward scanner

       // System.out.println("" + line);

       String[] strArr = line.split(",");  //split line at , (delimiter)

       data[row][col] = strArr[col];col++;  //adding values to matrix data

       data[row][col] = strArr[col];col++;

       data[row][col] = strArr[col];col++;

       data[row][col] = strArr[col];col++;

       data[row][col] = strArr[col];col++;

       //System.out.println(data[row][2]);

       col=0;row++; //read next row

      

           }

          

       }catch (FileNotFoundException e) {  //if file not found

           // TODO Auto-generated catch block

           System.out.println("students.dat file not found");

       }catch (NumberFormatException e) {  //if file is not properly formatted

           // TODO Auto-generated catch block

           System.out.println("students.dat file has wrong data");

       }

   }

   /*

   * create two reports

   * 1. which artists appear how many times

   * 2. Top streamed artists

   */

   public void reportArtists(){

      

       PrintWriter writer1 =null;   //to write to file

       PrintWriter writer2 =null;   

try {

           writer1 = new PrintWriter(new FileWriter(" "));  //open file artist.dat

           writer2 = new PrintWriter(new FileWriter(" "));  //open file topStramedArtists.dat

       } catch (FileNotFoundException e) {  //if file not found

           // TODO Auto-generated catch block

           System.out.println(" file not found");

       } catch (IOException e) {  //error in orpning file

           // TODO Auto-generated catch block

           System.out.println(" file is not accesible");

       }

String[] artistsArr = new String[rows];  //arrays to hold values

int[] count = new int[rows];

int[] streamCount = new int[rows];

int index = 0;

int atWhichIndex=-1;

for(int i=0;i<rows;i++){

  

   // System.out.println(data[i][2]);

   atWhichIndex = getArtistsExistsIndex(artistsArr,data[i][2]);  //find index in artist array of artist in ith row

   if(atWhichIndex<0){  //if not found in artist array, then add it to artist array

       artistsArr[index] = data[i][2];

       count[index]=count[index]+1;  //mark the position  in count array

       streamCount[index]=streamCount[index]+Integer.parseInt(data[i][3]); //add value to stream count

       index++;  //next index

   }else{ //if found then just increase stream count

       count[atWhichIndex]=count[atWhichIndex]+1;

       streamCount[atWhichIndex]=streamCount[atWhichIndex]+Integer.parseInt(data[i][3]);

   }

}

// Arrays.sort(streamCount);

for(int i=0;i<index;i++){  //write artist and values to file

   writer1.write(artistsArr[i]+","+count[i]+"\n");

   writer2.write(artistsArr[i]+","+streamCount[i]+"\n");   

}

//close files and flush buffers

writer1.flush();

writer1.close();

writer2.flush();

writer2.close();

      

   }

   /*

   * get position of artists in array

   */

   public int getArtistsExistsIndex(String[] arr, String artist){  //normal linear serach through the array

       int result=-1;

       for(int i=0;i<rows;i++){

           if(artist.equals(arr[i])){

                 

               return i;

           }

       }

       return result;

   }

    

}

class Artist{  //class to hold artist data

   String name;

   Artist next; //Makes it a linked-list

}

class topStreamingArtists{

   private Artist first; //Cannot be accessed outside the class

}
