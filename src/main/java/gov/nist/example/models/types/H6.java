//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.07.25 at 10:37:16 PM EDT 
//


package gov.nist.example.models.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;group ref="{http://csrc.nist.gov/ns/oscal/1.0}inlines"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "h6")
public class H6 {

    @XmlElementRefs({
        @XmlElementRef(name = "em", namespace = "http://csrc.nist.gov/ns/oscal/1.0", type = Em.class, required = false),
        @XmlElementRef(name = "i", namespace = "http://csrc.nist.gov/ns/oscal/1.0", type = I.class, required = false),
        @XmlElementRef(name = "strong", namespace = "http://csrc.nist.gov/ns/oscal/1.0", type = Strong.class, required = false),
        @XmlElementRef(name = "b", namespace = "http://csrc.nist.gov/ns/oscal/1.0", type = B.class, required = false),
        @XmlElementRef(name = "img", namespace = "http://csrc.nist.gov/ns/oscal/1.0", type = Img.class, required = false),
        @XmlElementRef(name = "code", namespace = "http://csrc.nist.gov/ns/oscal/1.0", type = Code.class, required = false),
        @XmlElementRef(name = "sub", namespace = "http://csrc.nist.gov/ns/oscal/1.0", type = Sub.class, required = false),
        @XmlElementRef(name = "sup", namespace = "http://csrc.nist.gov/ns/oscal/1.0", type = Sup.class, required = false),
        @XmlElementRef(name = "q", namespace = "http://csrc.nist.gov/ns/oscal/1.0", type = Q.class, required = false)
    })
    @XmlMixed
    protected List<Object> content;

    /**
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Em }
     * {@link I }
     * {@link Strong }
     * {@link B }
     * {@link String }
     * {@link Img }
     * {@link Code }
     * {@link Sub }
     * {@link Sup }
     * {@link Q }
     * 
     * 
     */
    public List<Object> getContent() {
        if (content == null) {
            content = new ArrayList<Object>();
        }
        return this.content;
    }

}