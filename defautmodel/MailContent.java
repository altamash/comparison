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
import defaultroot.defautmodel.domain.defautmodel.MailAddress;
import defaultroot.defautmodel.domain.defautmodel.MailContentProps;
import defaultroot.defautmodel.domain.defautmodel.MailAttachment;

/**
 *
 * <p>Title: MailContent</p>
 *
 * <p>Description: Domain Object describing a MailContent entity</p>
 *
 */
@Entity (name="MailContent")
@Table (name="\"mail_content\"")
@NamedQueries ({
	 @NamedQuery(name="MailContent.findAll", query="SELECT mailcontent FROM MailContent mailcontent")
	,@NamedQuery(name="MailContent.findByEmailSubject", query="SELECT mailcontent FROM MailContent mailcontent WHERE mailcontent.emailSubject = :emailSubject")
	,@NamedQuery(name="MailContent.findByEmailSubjectContaining", query="SELECT mailcontent FROM MailContent mailcontent WHERE mailcontent.emailSubject like :emailSubject")

	,@NamedQuery(name="MailContent.findByEmailBody", query="SELECT mailcontent FROM MailContent mailcontent WHERE mailcontent.emailBody = :emailBody")
	,@NamedQuery(name="MailContent.findByEmailBodyContaining", query="SELECT mailcontent FROM MailContent mailcontent WHERE mailcontent.emailBody like :emailBody")

	,@NamedQuery(name="MailContent.findByEmailContext", query="SELECT mailcontent FROM MailContent mailcontent WHERE mailcontent.emailContext = :emailContext")
	,@NamedQuery(name="MailContent.findByEmailContextContaining", query="SELECT mailcontent FROM MailContent mailcontent WHERE mailcontent.emailContext like :emailContext")

})

public class MailContent implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "MailContent.findAll";
    public static final String FIND_BY_EMAILSUBJECT = "MailContent.findByEmailSubject";
    public static final String FIND_BY_EMAILSUBJECT_CONTAINING ="MailContent.findByEmailSubjectContaining";
    public static final String FIND_BY_EMAILBODY = "MailContent.findByEmailBody";
    public static final String FIND_BY_EMAILBODY_CONTAINING ="MailContent.findByEmailBodyContaining";
    public static final String FIND_BY_EMAILCONTEXT = "MailContent.findByEmailContext";
    public static final String FIND_BY_EMAILCONTEXT_CONTAINING ="MailContent.findByEmailContextContaining";
	
    @Id @Column(name="mail_content_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer mailContentId;

//MP-MANAGED-ADDED-AREA-BEGINNING @email_subject-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @email_subject-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-email_subject@
    @Column(name="email_subject"  , length=400 , nullable=true , unique=false)
    private String emailSubject; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @email_body-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @email_body-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-email_body@
    @Column(name="email_body"   , nullable=true , unique=false)
    @Lob @Basic(fetch=FetchType.LAZY) 
    private String emailBody; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @email_context-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @email_context-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-email_context@
    @Column(name="email_context"  , length=400 , nullable=true , unique=false)
    private String emailContext; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @mailAddressMailContentViaMailContentId-field-mail_content@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.MailAddress.class, fetch=FetchType.LAZY, mappedBy="mailContentId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <MailAddress> mailAddressMailContentViaMailContentId = new HashSet<MailAddress>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @mailContentPropsMailContentViaMailContentId-field-mail_content@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.MailContentProps.class, fetch=FetchType.LAZY, mappedBy="mailContentId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <MailContentProps> mailContentPropsMailContentViaMailContentId = new HashSet<MailContentProps>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @m2m-mailAttachmentViaMailContentMailAttachmentByMailAttachmentId-mail_content@
    @ManyToMany
    @JoinTable(name="MAIL_CONTENT_MAIL_ATTACHMENT", 
        joinColumns=@JoinColumn(name="mail_content_id"), 
        inverseJoinColumns=@JoinColumn(name="mail_attachment_id") 
    )
    private Set <MailAttachment> mailAttachmentViaMailContentMailAttachmentByMailAttachmentId = new HashSet <MailAttachment> ();

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public MailContent() {
    }

	/**
	* All field constructor 
	*/
    public MailContent(
       Integer mailContentId,
       String emailSubject,
       String emailBody,
       String emailContext) {
	 this(
       mailContentId,
       emailSubject,
       emailBody,
       emailContext
	 ,true);
	}
    
	public MailContent(
       Integer mailContentId,
       String emailSubject,
       String emailBody,
       String emailContext	
    , boolean setRelationship) {
       //primary keys
       setMailContentId (mailContentId);
       //attributes
       setEmailSubject (emailSubject);
       setEmailBody (emailBody);
       setEmailContext (emailContext);
       //parents
    }

	public MailContent flat() {
	   return new MailContent(
          getMailContentId(),
          getEmailSubject(),
          getEmailBody(),
          getEmailContext()
       , false
	   );
	}

    public Integer getMailContentId() {
        return mailContentId;
    }
	
    public void setMailContentId (Integer mailContentId) {
        this.mailContentId =  mailContentId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-email_subject@
    public String getEmailSubject() {
        return emailSubject;
    }
	
    public void setEmailSubject (String emailSubject) {
        this.emailSubject =  emailSubject;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-email_body@
    public String getEmailBody() {
        return emailBody;
    }
	
    public void setEmailBody (String emailBody) {
        this.emailBody =  emailBody;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-email_context@
    public String getEmailContext() {
        return emailContext;
    }
	
    public void setEmailContext (String emailContext) {
        this.emailContext =  emailContext;
    }
	
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @mailAddressMailContentViaMailContentId-getter-mail_content@
    public Set<MailAddress> getMailAddressMailContentViaMailContentId() {
        if (mailAddressMailContentViaMailContentId == null){
            mailAddressMailContentViaMailContentId = new HashSet<MailAddress>();
        }
        return mailAddressMailContentViaMailContentId;
    }

    public void setMailAddressMailContentViaMailContentId (Set<MailAddress> mailAddressMailContentViaMailContentId) {
        this.mailAddressMailContentViaMailContentId = mailAddressMailContentViaMailContentId;
    }	
    
    public void addMailAddressMailContentViaMailContentId (MailAddress element) {
    	    getMailAddressMailContentViaMailContentId().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @mailContentMailAttachmentViaMailContentByMailContentId-getter-mail_content@
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @mailContentPropsMailContentViaMailContentId-getter-mail_content@
    public Set<MailContentProps> getMailContentPropsMailContentViaMailContentId() {
        if (mailContentPropsMailContentViaMailContentId == null){
            mailContentPropsMailContentViaMailContentId = new HashSet<MailContentProps>();
        }
        return mailContentPropsMailContentViaMailContentId;
    }

    public void setMailContentPropsMailContentViaMailContentId (Set<MailContentProps> mailContentPropsMailContentViaMailContentId) {
        this.mailContentPropsMailContentViaMailContentId = mailContentPropsMailContentViaMailContentId;
    }	
    
    public void addMailContentPropsMailContentViaMailContentId (MailContentProps element) {
    	    getMailContentPropsMailContentViaMailContentId().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING

    public Set<MailAttachment> getMailAttachmentViaMailContentMailAttachmentByMailAttachmentId() {
        if (mailAttachmentViaMailContentMailAttachmentByMailAttachmentId == null){
            mailAttachmentViaMailContentMailAttachmentByMailAttachmentId = new HashSet<MailAttachment>();
        }
        return mailAttachmentViaMailContentMailAttachmentByMailAttachmentId;
    }

    public void setMailAttachmentViaMailContentMailAttachmentByMailAttachmentId (Set<MailAttachment> mailAttachmentViaMailContentMailAttachmentByMailAttachmentId) {
        this.mailAttachmentViaMailContentMailAttachmentByMailAttachmentId = mailAttachmentViaMailContentMailAttachmentByMailAttachmentId;
    }
    	
    public void addMailAttachmentViaMailContentMailAttachmentByMailAttachmentId (MailAttachment element) {
        getMailAttachmentViaMailContentMailAttachmentByMailAttachmentId().add(element);
    }
	


//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
