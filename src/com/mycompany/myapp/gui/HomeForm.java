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
        Button pack = new Button("Packs");
        Button listpack = new Button("Liste Packs");
      
       
        setLayout(BoxLayout.y());
        setTitle("EnergyBox | CrossFitCenter");
        
        Label welcome = new Label("Welcome To EnergyBox");
        
        pack.addActionListener(e-> new PackForm().show());
        listpack.addActionListener(e-> new PackViewForm().show());
        
     
        
        
        homeContainer.add(welcome);
        btnContainer.add(pack);
      btnContainer.add(listpack);
        
        
        
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
                .addMaterialCommandToSideMenu("Packs",FontImage.MATERIAL_CALL_RECEIVED, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new PackForm().show();
            }
        } );
        getToolbar()
                .addMaterialCommandToSideMenu("list packs",FontImage.MATERIAL_CALL_RECEIVED, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new PackViewForm().show();
            }
        } );
       
           getToolbar()
                .addMaterialCommandToSideMenu("list Abonnements",FontImage.MATERIAL_CALL_RECEIVED, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new AbonnementViewForm().show();
            }
        } );
           
       
        
    }
    
    
}

