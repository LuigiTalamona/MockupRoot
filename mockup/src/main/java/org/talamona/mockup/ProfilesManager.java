/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.mockup;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.net.URL;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author luigi
 */
public class ProfilesManager {

    private String xmlProfiles = "users.xml";
    private Document doc;

    public ProfilesManager() {
        this.doc = this.readProfiles();
    }

    public boolean isProfiled(String user) {
        boolean retValue = false;
        if (this.doc != null) {
            NodeList nodeList = doc.getElementsByTagName("user");
            if (nodeList != null && nodeList.getLength() > 0) {
                Node node = null;
                String nodeValue = null;
                for (int i = 0; i < nodeList.getLength(); i++) {
                    node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element e = (Element) node;
                        nodeValue = getTextValue(e, "id");
                        if (nodeValue != null) {
                            // OR operator and assignment
                            retValue |= (nodeValue.equals(user));
                        }
                    }
                }
            }
        }
        return retValue;


    }

    public User readProfile(String id) {
        User retValue = null;
        if (id != null && this.isProfiled(id)) {
            NodeList nodeList = doc.getElementsByTagName("user");
            if (nodeList != null && nodeList.getLength() > 0) {
                Node node = null;
                String nodeValue = null;
                for (int i = 0; i < nodeList.getLength(); i++) {
                    node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element e = (Element) node;
                        nodeValue = getTextValue(e, "id");
                        if (nodeValue != null && nodeValue.equals(id)) {
                            retValue = new User();
                            retValue.setId(nodeValue);
                            retValue.setARSSid(this.getTextValue(e, "ARSSid"));
                            retValue.setARSSpwd(this.getTextValue(e, "ARSSpwd"));
                        }
                    }
                }
            }
        }



        return retValue;
    }

    public boolean writeProfile(User profile) {
        boolean retValue = false;
        if (this.doc != null) {
            try {
                Node users = doc.getFirstChild();

                Node user = doc.createElement("user");
                Node id = doc.createElement("id");
                Node ARSSid = doc.createElement("ARSSid");
                Node ARSSpwd = doc.createElement("ARSSpwd");

                id.setTextContent(profile.getId());
                ARSSid.setTextContent(profile.getARSSid());
                ARSSpwd.setTextContent(profile.getARSSpwd());

                user.appendChild(id);
                user.appendChild(ARSSid);
                user.appendChild(ARSSpwd);

                users.appendChild(user);

                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                //initialize StreamResult with File object to save to file
                URL url = this.getClass().getClassLoader().getResource(this.xmlProfiles);


                StreamResult result = new StreamResult(new File(url.getFile()));
                DOMSource source = new DOMSource(doc);
                transformer.transform(source, result);

                this.doc = this.readProfiles();
                retValue = true;




            } catch (TransformerException ex) {
                Logger.getLogger(ProfilesManager.class.getName()).log(Level.SEVERE, null, ex);
            }








        }
        return retValue;
    }

    private Document readProfiles() {
        Document retValue = null;
        try {
            InputStream stream = this.getClass().getClassLoader().getResourceAsStream(this.xmlProfiles);

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            retValue = docBuilder.parse(stream);
            retValue.getDocumentElement().normalize();
            stream.close();




        } catch (SAXException ex) {
            Logger.getLogger(ProfilesManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProfilesManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ProfilesManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retValue;


    }

    private String getTextValue(Element ele, String tagName) {
        String retValue = null;
        NodeList nl = ele.getElementsByTagName(tagName);
        if (nl != null && nl.getLength() > 0) {
            Element el = (Element) nl.item(0);
            if (el.getFirstChild() != null) {
                retValue = el.getFirstChild().getNodeValue();
            }
        }

        return retValue;
    }
}
