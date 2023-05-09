/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;


/**
 *
 * @author azizo
 */
public class HomeForm extends Form{

    public HomeForm(){
        
        
        Container homeContainer = new Container(new FlowLayout(CENTER,CENTER));
        Container btnContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container btnContainerT = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        

        Button competition=new Button("Competition");
        setLayout(BoxLayout.y());
        Button Ticket=new Button("Ticket");
        setLayout(BoxLayout.y());
        setTitle("EnergyBox | CrossFitCenter");
        
        Label welcome = new Label("Welcome To EnergyBox");
        
        competition.addActionListener(e-> new CompetitionForm().show());
       Ticket.addActionListener(e->new TicketForm().show());
        homeContainer.add(welcome);
        btnContainer.add(competition);
        btnContainerT.add(Ticket);
        
        
        
        add(homeContainer);
        add(btnContainer);
        add(btnContainerT);
   
        getToolbar()
                .addMaterialCommandToSideMenu("Home",FontImage.MATERIAL_CALL_RECEIVED, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new HomeForm().show();
            }
        } );
        
           getToolbar()
                .addMaterialCommandToSideMenu("Competition",FontImage.MATERIAL_CALL_RECEIVED, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new CompetitionForm().show();
            }
        } );
           
            getToolbar()
                .addMaterialCommandToSideMenu("Ticket",FontImage.MATERIAL_CALL_RECEIVED, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new TicketForm().show();
            }
        } );
        
        
        
    }
    
    
}

