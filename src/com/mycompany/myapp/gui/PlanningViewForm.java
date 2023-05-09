/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.mycompany.myapp.entities.Planning;
import com.mycompany.myapp.services.ServicePlanning;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author azizo
 */
public class PlanningViewForm extends Form{
    Form current;
    public PlanningViewForm() throws ParseException{
        /*VIEW*/
        current = this;
        Toolbar tb = new Toolbar(false);
        current.setToolbar(tb);
        
        tb.setTitle("Afficher Plannings");
        getContentPane().setScrollVisible(true);
        
        tb.addSearchCommand(e ->{
            
        });
        Container viewContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
        ArrayList<Planning>list = ServicePlanning.getInstance().AfficherPlanning();
        
        for(Planning p : list ) {
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
            Date d=dateFormat.parse(String.valueOf(p.getDatePlanning()));
            
            Label datePlanningTxt = new Label("Date Planning : "+d);
            Label jourPlanningTxt = new Label("Jour Planning : "+p.getJourPlanning());
            Label heurePlanningTxt = new Label("Heure Planning : "+p.getHeurePlanning());
            
            Label separator = new Label("**************************");
            
            Container cn=new Container(new BoxLayout(BoxLayout.Y_AXIS));
            
            cn.add(datePlanningTxt);
            cn.add(jourPlanningTxt);
            cn.add(heurePlanningTxt);

            
            Label PlanningSupprimer = new Label(" ");
            PlanningSupprimer.setUIID("NewsTopLine");
            Style supprmierStyle = new Style(PlanningSupprimer.getUnselectedStyle());
            supprmierStyle.setFgColor(0xf21f1f);

            FontImage suprrimerImage = FontImage.createMaterial(FontImage.MATERIAL_DELETE, supprmierStyle);
            PlanningSupprimer.setIcon(suprrimerImage);
            PlanningSupprimer.setTextPosition(RIGHT);

            //click delete icon
            PlanningSupprimer.addPointerPressedListener(l -> {

                Dialog dig = new Dialog("Suppression");

                if(dig.show("Suppression","Vous voulez supprimer ce Planning ?","Annuler","Oui")) {
                    dig.dispose();
                }
                else {
                    dig.dispose();
                     }
                    //n3ayto l suuprimer men service Reclamation
                    if(ServicePlanning.getInstance().SupprimerPlanning(p.getId())) {
                        try {
                            new PlanningViewForm().show();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }

            });
            
            //Update icon 
            Label PlanningModifier = new Label(" ");
            PlanningModifier.setUIID("NewsTopLine");
            Style modifierStyle = new Style(PlanningModifier.getUnselectedStyle());
            modifierStyle.setFgColor(0xf7ad02);

            FontImage mFontImage = FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, modifierStyle);
            PlanningModifier.setIcon(mFontImage);
            PlanningModifier.setTextPosition(LEFT);


            PlanningModifier.addPointerPressedListener(l -> {
                try{
                    new PlanningEditForm(p).showBack();
                }catch(Exception e){
                    e.printStackTrace();
                }
                
            });


            cn.add(PlanningSupprimer);
            cn.add(PlanningModifier);
            cn.add(separator);

            add(cn);
        }
        
        add(viewContainer);
        
        
        

        
        
        
        getToolbar().addCommandToLeftBar("Back",null,(ActionListener) (ActionEvent evt1) -> {
                new PlanningForm().showBack();
        });
        
        /*FIN VIEW*/
    }
    
}
