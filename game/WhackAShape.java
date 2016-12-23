package game;

import java.awt.Color;
import CS2114.Button;
import CS2114.CircleShape;
import CS2114.Shape;
import CS2114.SquareShape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;
import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * creates the GUI
 * 
 * @author usmana
 * @version 9/24/2016
 */
public class WhackAShape
{
    private SimpleBagInterface<Shape> bag;
    private Window                    window;
    private TestableRandom            randomGenerator = new TestableRandom();
    private Button                    quitButton      = new Button("Quit");


    /**
     * default constructor for WhackAShape
     */
    public WhackAShape()
    {
        bag = new SimpleLinkedBag<Shape>();
        this.window = new Window();
        window.addButton(quitButton, WindowSide.NORTH);
        quitButton.onClick(this, "clickedQuit");
        bag.add(buildShape("blue circle"));
        bag.add(buildShape("blue square"));
        bag.add(buildShape("red square"));
        bag.add(buildShape("red circle"));
        window.addShape(bag.pick());

    }


    /**
     * overloaded constructor for WhacAShape with String [] inputs
     * 
     * @param inputs
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public WhackAShape(String[] inputs)
    {
        SimpleLinkedBag bag = new SimpleLinkedBag<>();
        this.window = new Window();
        window.addButton(quitButton, WindowSide.NORTH);
        quitButton.onClick(this, "clickedQuit");

        try
        {
            for (int i = 0; i < inputs.length; i++)
            {
                bag.add(buildShape(inputs[i]));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        window.addShape((Shape)bag.pick());

    }


    /**
     * @return a bag interface type of Shape
     */
    public SimpleBagInterface<Shape> getBag()
    {
        return bag;

    }


    /**
     * exits the program
     * 
     * @param button
     */
    public void clickedQuit(Button button)
    {
        System.exit(0);
    }


    /**
     * @return the Window object instantiated
     */
    public Window getWindow()
    {

        return window;
    }


    /*
     * method to show shapes onto screen
     */
    public void clickedShape(Shape clickShape)
    {
        window.removeShape(clickShape);
        bag.remove(clickShape);
        Shape nextShape = bag.pick();
        if (nextShape == null)
        {

            TextShape txtshape = new TextShape((window.getGraphPanelHeight()
                / 2), window.getGraphPanelWidth() / 2, "");
            txtshape.setText("You Win!");
            window.addShape(txtshape);

        }
        else
        {
            window.addShape(nextShape);
        }

    }


    /**
     * @param temp
     * @return a Shape based on the string input
     * @throws IllegalArguementException
     *             when input is not valid
     */
    private Shape buildShape(String temp)
    {
        Shape currentShape = new Shape(0, 0);

        int size = randomGenerator.nextInt(101) + 100;
        int x = size;
        int y = size;

        if (temp.contains("red circle"))
        {
            currentShape = new CircleShape(x, y, Color.red);
        }
        else if (temp.contains("red square"))
        {
            currentShape = new SquareShape(x, y, Color.red);
        }
        else if (temp.contains("blue square"))
        {
            currentShape = new SquareShape(x, y, Color.blue);
        }
        else if (temp.contains("blue circle"))
        {
            currentShape = new SquareShape(x, y, Color.blue);
        }

        else
        {
            throw new IllegalArgumentException("wrong input");
        }

        currentShape.onClick(this, "clickedShape");

        return currentShape;
    }

}
