package com.givenm.xyzenterprises;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

public class NonPersistandDataManager {
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public String FirstInterface;
    public String ButtonLabel;
    public String SecondInterface;
    public String Language;
    public NonPersistandDataManager(Context context) {
        this.prefs = context.getSharedPreferences("XYZ Enterprises", MODE_PRIVATE);
        this.getCurrentLanguage();
    }

    public void setLanguage(String languageToSet){
        this.editor = prefs.edit();
        this.editor.putString("selectedLanguage", languageToSet);

        if (languageToSet.equals("English")) {
            this.editor.putString("first_interface", "Welcome to XYZ\nEnterprises");
            this.editor.putString("button_label", "Next");
            this.editor.putString("second_interface", "You're one step\ncloser!");
        } else if (languageToSet.equals("French")) {
            this.editor.putString("first_interface", "Bienvenue chez XYZ\nEntreprises");
            this.editor.putString("button_label", "Suivante");
            this.editor.putString("second_interface", "Vous êtes un pas de\nplus!");
        } else if (languageToSet.equals("Spanish")) {
            this.editor.putString("first_interface", "Bienvenido a\nEmpresas XYZ!");
            this.editor.putString("button_label", "Próxima");
            this.editor.putString("second_interface", "¡Estás un paso más\ncerca!");
        }
        editor.commit();

        this.getCurrentLanguage();
    }

    private void getCurrentLanguage() {
        this.Language = prefs.getString("selectedLanguage", "English");
        this.FirstInterface = prefs.getString("first_interface", "Welcome to XYZ\nEnterprises");
        this.ButtonLabel = prefs.getString("button_label", "Next");
        this.SecondInterface = prefs.getString("second_interface", "You're one step\ncloser!");
    }
}
