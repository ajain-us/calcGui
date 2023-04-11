import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guiPartTwo {

    private JFrame frame;
    private JPanel main;

    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    private JButton zero;

    private JButton clear;
    private JButton add;
    private JButton sub;
    private JButton mut;
    private JButton div;
    private JButton decimal;
    private JButton enter;

    private JTextField output;

    private ButtonListener listenForEvent;

    private String input;
    private String num1;
    //private String num2;
    private int operation;
    private boolean decimalPressed;
    private String answer;



    public guiPartTwo(){
        input = "";
        answer = "";
        listenForEvent = new ButtonListener();
        frame = new JFrame("Traditional Calc");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,220);
        main = (JPanel)frame.getContentPane();
        main.setLayout(new BorderLayout());

        JPanel numberPad = new JPanel();
        numberPad.setLayout(new GridLayout(4,0));
        JPanel first = new JPanel();
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        first.add(one);
        first.add(two);
        first.add(three);
        JPanel second = new JPanel();
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        second.add(four);
        second.add(five);
        second.add(six);
        JPanel third = new JPanel();
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        third.add(seven);
        third.add(eight);
        third.add(nine);
        JPanel fourth = new JPanel();
        clear = new JButton("Clear");
        zero = new JButton("0");
        decimal = new JButton(".");
        fourth.add(clear);
        fourth.add(zero);
        fourth.add(decimal);

        numberPad.add(first);
        numberPad.add(Box.createVerticalGlue());
        numberPad.add(second);
        numberPad.add(Box.createVerticalGlue());
        numberPad.add(third);
        numberPad.add(Box.createVerticalGlue());
        numberPad.add(fourth);


        JPanel operations = new JPanel();
        operations.setLayout(new BoxLayout(operations, BoxLayout.Y_AXIS));
        add = new JButton("+");
        sub = new JButton("-");
        mut = new JButton("x");
        div = new JButton("/");
        enter = new JButton("=");
        operations.add(add);
        operations.add(Box.createVerticalGlue());
        operations.add(sub);
        operations.add(Box.createVerticalGlue());
        operations.add(mut);
        operations.add(Box.createVerticalGlue());
        operations.add(div);
        operations.add(Box.createVerticalGlue());
        operations.add(enter);



        JPanel middle = new JPanel();
        middle.add(numberPad);
        middle.add(operations);

        output = new JTextField("",10);
        output.setEditable(false);

        one.addActionListener(listenForEvent);
        two.addActionListener(listenForEvent);
        three.addActionListener(listenForEvent);
        four.addActionListener(listenForEvent);
        five.addActionListener(listenForEvent);
        six.addActionListener(listenForEvent);
        seven.addActionListener(listenForEvent);
        eight.addActionListener(listenForEvent);
        nine.addActionListener(listenForEvent);
        zero.addActionListener(listenForEvent);
        decimal.addActionListener(listenForEvent);
        clear.addActionListener(listenForEvent);
        add.addActionListener(listenForEvent);
        sub.addActionListener(listenForEvent);
        mut.addActionListener(listenForEvent);
        div.addActionListener(listenForEvent);
        enter.addActionListener(listenForEvent);


        main.add(output,BorderLayout.PAGE_START);
        main.add(middle,BorderLayout.CENTER);

        frame.setVisible(true);


    }
    public static void main(String[] args) {
            new guiPartTwo();
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JButton pressed = (JButton)event.getSource();

            if(pressed == one){
                input += "1";
                answer = "";
            }else if(pressed == two){
                input+= "2";
                answer = "";
            }else if(pressed == three){
                input  += "3";
                answer = "";
            }else if(pressed == four){
                input+= "4;";
                answer = "";
            }else if(pressed == five){
                input += "5";
                answer = "";
            }else if(pressed == six){
                input += "6";
                answer = "";
            }else if(pressed == seven){
                input += "7";
                answer = "";
            }else if(pressed == eight){
                input += "8";
                answer = "";
            }else if(pressed == nine){
                input += "9";
                answer = "";
            }else if(pressed == zero){
                input += "0";
                answer = "";
            }else if(pressed == decimal && !decimalPressed) {
                input += ".";
                decimalPressed = true;
                answer = "";
            }else if(pressed == clear){
                input = "";
                decimalPressed = false;
            }
            output.setText(input);

            if(input.equals("")){
                if(answer == null){
                    output.setText("Please Enter a number before continuing");
                }else{
                    num1 = answer;
                    if(pressed == add){
                        operation = 1;
                        output.setText("+");

                        input = "";
                        decimalPressed = false;
                    }else if(pressed == sub){
                        operation = 2;
                        output.setText("-");

                        input = "";
                        decimalPressed = false;
                    }else if(pressed == mut){
                        operation = 3;
                        output.setText("x");

                        input = "";
                        decimalPressed = false;
                    }else if(pressed == div){
                        operation = 4;
                        output.setText("/");

                        input = "";
                        decimalPressed = false;
                    }
                }

            }else{
                if(pressed == add){
                    operation = 1;
                    output.setText("+");
                    num1 = input;
                    input = "";
                    decimalPressed = false;
                }else if(pressed == sub){
                    operation = 2;
                    output.setText("-");
                    num1 = input;
                    input = "";
                    decimalPressed = false;
                }else if(pressed == mut){
                    operation = 3;
                    output.setText("x");
                    num1 = input;
                    input = "";
                    decimalPressed = false;
                }else if(pressed == div){
                    operation = 4;
                    output.setText("/");
                    num1 = input;
                    input = "";
                    decimalPressed = false;
                }else if(pressed == enter){
                    if(input.equals("")){
                        output.setText("Please enter a second number");
                    }else{
                        switch (operation){
                            case 0:
                                output.setText("please enter an operation first");
                                break;
                            case 1:
                                answer += (Double.parseDouble(num1) + Double.parseDouble(input));
                                break;
                            case 2:
                                answer += Double.parseDouble(num1) - Double.parseDouble(input);
                                break;
                            case 3:
                                answer += Double.parseDouble(num1) * Double.parseDouble(input);
                                break;
                            case 4:
                                answer += Double.parseDouble(num1) / Double.parseDouble(input);
                                break;

                        }
                        output.setText(answer);
                        input = "";
                    }
                }
            }



        }
    }

}
