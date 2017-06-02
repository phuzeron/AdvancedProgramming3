/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture7;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author phuzeron
 */
public class World extends JFrame{

    JPanel panel;
    private List<Actor> actorList;

    public World(String title){
        super();
        setTitle(title);
        setBounds(0, 0, 300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        Container contentPane = getContentPane();
        contentPane.add(panel, BorderLayout.CENTER);
        actorList = new ArrayList<>();
    }

    public void addObject(Actor object, int x, int y){
        actorList.add(object);
        panel.add(object.getIcon());
        object.setLocation(x, y);
    }

    @Override
    public void repaint(){
        for(Actor actor : actorList){
            actor.act();
        }
    }

}
