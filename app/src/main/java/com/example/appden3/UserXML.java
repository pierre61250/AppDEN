package com.example.appden3;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class UserXML {
    private static String NODE_ATTR_PROBA = "probatoire";
    private static String NODE_ATTR_POINTS = "points";

    private Context context;
    private static Document profil_conducteur;

    public UserXML(Context context) {
        this.context = context;
    }

    private Document parseXml(String fileName) {
        try {
            InputStream is = context.getAssets().open(fileName);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(is);
            doc.getDocumentElement().normalize();

            Log.i("parsing", "Document " + fileName + " was parsed correctly");
            is.close();
            return doc;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            Log.e("xml", "Error on parsing " + fileName);
        }

        return null;
    }

    private String getStringAttribute(Element elem, String nomAttribute) {
        return elem.getAttribute(nomAttribute);
    }

    public ArrayList<ProfilUser> getProfilsUsers() {
        ArrayList<ProfilUser> usersProfil = new ArrayList<>();

        profil_conducteur = parseXml("profil_conducteur.xml");
        NodeList users = profil_conducteur.getElementsByTagName("profil");

        for (int i = 0; i < users.getLength(); i++) {
            Node node = users.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element user = (Element) node;

                String name = user.getTextContent();
                boolean probatoire = Boolean.parseBoolean(getStringAttribute(user, NODE_ATTR_PROBA));
                int points = Integer.parseInt(getStringAttribute(user, NODE_ATTR_POINTS));

                ProfilUser userProfil = ProfilUser.createNewUser(name, probatoire, points);
                usersProfil.add(userProfil);
            }
        }

        return usersProfil;
    }

}
