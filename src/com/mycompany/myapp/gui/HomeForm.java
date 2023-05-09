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
        
        Button activite = new Button("Activites");
        Button cours = new Button("Cours");
        Button planning = new Button("Planning");
        setLayout(BoxLayout.y());
        setTitle("EnergyBox | CrossFitCenter");
        
        Label welcome = new Label("Welcome To EnergyBox");
        
        
        activite.addActionListener(e-> new ActiviteForm().show());
        cours.addActionListener(e-> new CoursForm().show());
        planning.addActionListener(e-> new PlanningForm().show());
        
        
        homeContainer.add(welcome);
        
        btnContainer.add(activite);
        btnContainer.add(cours);
        btnContainer.add(planning);
        
        
        
        add(homeContainer);
        add(btnContainer);
        
        
        
        
        
        getToolbar()
                .addMaterialCommandToSideMenu("Home",FontImage.MATERIAL_CALL_RECEIVED, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new HomeForm().show();
            }
        } );
        getToolbar()
                .addMaterialCommandToSideMenu("Activités",FontImage.MATERIAL_CALL_RECEIVED, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new ActiviteForm().show();
            }
        } );
        getToolbar()
                .addMaterialCommandToSideMenu("Cours",FontImage.MATERIAL_CALL_RECEIVED, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new CoursForm().show();
            }
        } );
        getToolbar()
                .addMaterialCommandToSideMenu("Planning",FontImage.MATERIAL_CALL_RECEIVED, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new PlanningForm().show();
            }
        } );
        
        
        
    }
    
    
}

