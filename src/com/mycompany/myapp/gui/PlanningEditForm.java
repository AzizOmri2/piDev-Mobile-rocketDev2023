/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Planning;
import com.mycompany.myapp.services.ServicePlanning;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author azizo
 */
public class PlanningEditForm extends Form{
    
    public PlanningEditForm(Planning p) throws ParseException{
        
        
        
            Container cn=new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container CnBtn=new Container(new BoxLayout(BoxLayout.X_AXIS));
            Button btnModifier=new Button("Modifier");
            Button btnAnnuler = new Button("Annuler");
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            Date d=dateFormat.parse(String.valueOf(p.getDatePlanning()));
            
            TextField datePlanning = new TextField(String.valueOf(d), "Date Planning" , 20 , TextField.ANY);
            TextField jourPlanning = new TextField(p.getJourPlanning(), "Jour Planning" , 20 , TextField.ANY);
            TextField heurePlanning = new TextField(String.valueOf(p.getHeurePlanning()) , "Heure Planning" , 20 , TextField.ANY);
            
            
            cn.add(datePlanning);
            cn.add(jourPlanning);
            cn.add(heurePlanning);
            CnBtn.add(btnModifier);
            CnBtn.add(btnAnnuler);
            
            
            
            btnModifier.addPointerPressedListener(l ->   {
                try {
                    String dd=datePlanning.getText();
                    Date dateP=dateFormat2.parse(dd);
                    p.setDatePlanning(dateP);
                    
                    p.setJourPlanning(jourPlanning.getText());
                    p.setHeurePlanning(Integer.parseInt(heurePlanning.getText()));
                    if(ServicePlanning.getInstance().ModifierPlanning(p)) { // if true
                        new PlanningViewForm().show();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            
            
            btnAnnuler.addActionListener(e -> {
                try {
                    new PlanningViewForm().show();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            
            
            add(cn);
            add(CnBtn);
        
    }
}
