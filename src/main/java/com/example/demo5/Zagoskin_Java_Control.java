package com.example.demo5;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


import java.util.ArrayList;
import java.util.Arrays;



public class Zagoskin_Java_Control {
    @FXML
    private Label infoText1, infoText2, infoText3;
    @FXML
    public TextField numTextField, nameTextField, seqTextField;
    @FXML
    public TextArea textAreaStr;
    @FXML
    public Button seqBtn, strBtn, strEnterBtn, seqEnterLengthBtn, seqResult;
    @FXML
    public AnchorPane mainPane;
    public String str;
    public ArrayList<Integer> finArray = new ArrayList<Integer>(0);
    @FXML
    public void onEnterButtonClick1() {
        String s;
        s = numTextField.getText();
        double N;
        try {
            N = Double.parseDouble(s);
            if (N > 7) {
                infoText1.setText("Привет");
            } else {
                infoText1.setText("Введенное число меньше чем 7");
            }
        } catch (Exception e) {
            if (s.equals("")) {
                infoText1.setText("Ошибка! Вы ничего не ввели");
            } else {

                infoText1.setText("Ошибка! Вы ввели «" + s + "». Пожалуйста убедитесь, это число.");
            }
        }
    }

    @FXML
    public void onEnterButtonClick2() {
        String s;
        s = nameTextField.getText();
        if (s.equalsIgnoreCase("Вячеслав") || s.equalsIgnoreCase("Vyacheslav")) {
            infoText2.setText("Привет, Вячеслав");
            nameTextField.setDisable(true);
            nameTextField.setVisible(false);
        } else {
            infoText2.setText("Нет такого имени");
        }
    }

    @FXML
    public void onStrBtnClick() {

        seqBtn.setDisable(true);
        seqBtn.setVisible(false);
        strBtn.setDisable(true);
        strBtn.setVisible(false);
        seqTextField.setDisable(true);
        seqTextField.setVisible(false);
        textAreaStr.setDisable(false);
        textAreaStr.setVisible(true);
        strEnterBtn.setDisable(false);
        strEnterBtn.setVisible(true);
        strBtn.toFront();
        textAreaStr.toFront();

        infoText3.setText("Введите все элементы массива в одну строку через пробел");

    }

    @FXML
    public void onStrEnterBtnClick() {

        String s = textAreaStr.getText();
        String[] array = s.split(" ");
        int[] array1 = new int[array.length];
        int counter1 = 0;
        try {
            for (int i = 0; i < array.length; i++) {
                array1[i] = Integer.valueOf(array[i]);
                if (array1[i] % 3 == 0) {
                    counter1++;
                }
            }
            int[] array2 = new int[counter1];
            int counter2 = 0;

            for (int j = 0; j < array1.length; j++) {
                if (array1[j] % 3 == 0) {
                    array2[counter2] = array1[j];
                    counter2++;
                }
            }
            String arr2 = Arrays.toString(array2);
            infoText3.setText("Вот числа массива, кратные 3: " + arr2);
            textAreaStr.clear();
        } catch (Exception e) {
            infoText3.setText("Ошибка! В числовом массиве обнаружено не числовое значение, попробуйте еще раз.");
        }
    }

    public ArrayList<Integer> revArray = new ArrayList<Integer>(0);
    public int counter = 0;
    @FXML
    public void onSeqBtnClick() {
        seqBtn.setDisable(true);
        seqBtn.setVisible(false);
        strBtn.setDisable(true);
        strBtn.setVisible(false);

        seqEnterLengthBtn.setVisible(true);
        seqEnterLengthBtn.setDisable(false);
        seqResult.setDisable(false);
        seqResult.setVisible(true);
        seqTextField.setDisable(false);
        seqTextField.clear();
        infoText3.setText("Введите "+ (counter+1)+"-й элемент массива");
        seqTextField.setVisible(true);
        seqTextField.setDisable(false);
        str = "1";
        try {
            int i = Integer.parseInt(str);
            revArray.add(i);
            counter++;
            seqTextField.clear();
        } catch (Exception e){infoText3.setText(str+" не может быть принято, убедитесь, что вводите целые числа");
        }
        seqTextField.clear();
        revArray.clear();
    }
    @FXML
   public void onSeqEnterLengthBtnClick() {

        infoText3.setText("Введите "+ (counter+1)+"-й элемент массива");
        seqTextField.setVisible(true);
        seqTextField.setDisable(false);
        str = seqTextField.getText();
        try {
            int i = Integer.parseInt(str);
            revArray.add(i);
            counter++;
            seqTextField.clear();
        } catch (Exception e){
            if (str=="") {
                infoText3.setText("Вы ничего не ввели");
            } else {infoText3.setText(str+" не может быть принято, убедитесь, что вводите целые числа");
        }}

    }




    @FXML
    public void onSeqResult(){
        for (int i = 0; i<revArray.size(); i++){
            int j = revArray.get(i);
            if (j%3==0) {
                finArray.add(j);
            } else {infoText3.setText("Непредвиденная ошибка");}
        }
        infoText3.setText("Среди "+revArray+" кратны 3 - "+finArray);
        finArray.clear();

    }
    @FXML
    public void onReFreshBtnClick() {
        seqBtn.setDisable(false);
        seqBtn.setVisible(true);
        strBtn.setDisable(false);
        strBtn.setVisible(true);
        seqEnterLengthBtn.setDisable(true);
        seqEnterLengthBtn.setVisible(false);
        seqResult.setDisable(true);
        seqResult.setVisible(false);
        seqTextField.setDisable(true);
        seqTextField.setVisible(false);
        strEnterBtn.setDisable(true);
        strEnterBtn.setVisible(false);
        textAreaStr.setDisable(true);
        textAreaStr.setVisible(false);
        infoText3.setText("Как будем вводить массив?");
        counter=0;
        revArray.clear();
        finArray.clear();

    }


}