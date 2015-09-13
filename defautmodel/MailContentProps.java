/**
	* Copyright (c) minuteproject, minuteproject@gmail.com
	* All rights reserved.
	* 
	* Licensed under the Apache License, Version 2.0 (the "License")
	* you may not use this file except in compliance with the License.
	* You may obtain a copy of the License at
	* 
	* http://www.apache.org/licenses/LICENSE-2.0
	* 
	* Unless required by applicable law or agreed to in writing, software
	* distributed under the License is distributed on an "AS IS" BASIS,
	* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	* See the License for the specific language governing permissions and
	* limitations under the License.
	* 
	* More information on minuteproject:
	* twitter @minuteproject
	* wiki http://minuteproject.wikispaces.com 
	* blog http://minuteproject.blogspot.net
	* 
*/
/**
	* template reference : 
	* - Minuteproject version : 0.9
	* - name      : DomainEntityJPA2Annotation
	* - file name : DomainEntityJPA2Annotation.vm
*/
package defaultroot.defautmodel.domain.defautmodel;

//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import java.io.Serializable;
import javax.persistence.*;
import defaultroot.defautmodel.domain.defautmodel.MailContent;

/**
 *
 * <p>Title: MailContentProps</p>
 *
 * <p>Description: Domain Object describing a MailContentProps entity</p>
 *
 */
@Entity (name="MailContentProps")
@Table (name="\"mail_content_props\"")
@NamedQueries ({
	 @NamedQuery(name="MailContentProps.findAll", query="SELECT mailcontentprops FROM MailContentProps mailcontentprops")
	,@NamedQuery(name="MailContentProps.findByPropName", query="SELECT mailcontentprops FROM MailContentProps mailcontentprops WHERE mailcontentprops.propName = :propName")
	,@NamedQuery(name="MailContentProps.findByPropNameContaining", query="SELECT mailcontentprops FROM MailContentProps mailcontentprops WHERE mailcontentprops.propName like :propName")

	,@NamedQuery(name="MailContentProps.findByPropValue", query="SELECT mailcontentprops FROM MailContentProps mailcontentprops WHERE mailcontentprops.propValue = :propValue")
	,@NamedQuery(name="MailContentProps.findByPropValueContaining", query="SELECT mailcontentprops FROM MailContentProps mailcontentprops WHERE mailcontentprops.propValue like :propValue")

})

public class MailContentProps implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "MailContentProps.findAll";
    public static final String FIND_BY_PROPNAME = "MailContentProps.findByPropName";
    public static final String FIND_BY_PROPNAME_CONTAINING ="MailContentProps.findByPropNameContaining";
    public static final String FIND_BY_PROPVALUE = "MailContentProps.findByPropValue";
    public static final String FIND_BY_PROPVALUE_CONTAINING ="MailContentProps.findByPropValueContaining";
	
    @Id @Column(name="mail_content_props_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer mailContentPropsId;

//MP-MANAGED-ADDED-AREA-BEGINNING @prop_name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @prop_name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-prop_name@
    @Column(name="prop_name"  , length=80 , nullable=false , unique=false)
    private String propName; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @prop_value-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @prop_value-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-prop_value@
    @Column(name="prop_value"  , length=256 , nullable=true , unique=false)
    private String propValue; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="mail_content_id", referencedColumnName = "mail_content_id" , nullable=false , unique=false , insertable=true, updatable=true) 
    private MailContent mailContentId;  

    @Column(name="mail_content_id"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer mailContentId_;

    /**
    * Default constructor
    */
    public MailContentProps() {
    }

	/**
	* All field constructor 
	*/
    public MailContentProps(
       Integer mailContentPropsId,
       Integer mailContentId,
       String propName,
       String propValue) {
	 this(
       mailContentPropsId,
       mailContentId,
       propName,
       propValue
	 ,true);
	}
    
	public MailContentProps(
       Integer mailContentPropsId,
       Integer mailContentId,
       String propName,
       String propValue	
    , boolean setRelationship) {
       //primary keys
       setMailContentPropsId (mailContentPropsId);
       //attributes
       setPropName (propName);
       setPropValue (propValue);
       //parents
       if (setRelationship) this.mailContentId = new MailContent();
       if (setRelationship) this.mailContentId.setMailContentId(mailContentId); 
	   setMailContentId_ (mailContentId);
    }

	public MailContentProps flat() {
	   return new MailContentProps(
          getMailContentPropsId(),
          getMailContentId_(),
          getPropName(),
          getPropValue()
       , false
	   );
	}

    public Integer getMailContentPropsId() {
        return mailContentPropsId;
    }
	
    public void setMailContentPropsId (Integer mailContentPropsId) {
        this.mailContentPropsId =  mailContentPropsId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-prop_name@
    public String getPropName() {
        return propName;
    }
	
    public void setPropName (String propName) {
        this.propName =  propName;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-prop_value@
    public String getPropValue() {
        return propValue;
    }
	
    public void setPropValue (String propValue) {
        this.propValue =  propValue;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public MailContent getMailContentId () {
    	return mailContentId;
    }
	
    public void setMailContentId (MailContent mailContentId) {
    	this.mailContentId = mailContentId;
    }

    public Integer getMailContentId_() {
        return mailContentId_;
    }
	
    public void setMailContentId_ (Integer mailContentId) {
        this.mailContentId_ =  mailContentId;
    }
	




//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
