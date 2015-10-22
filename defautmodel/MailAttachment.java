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
 * <p>Title: MailAttachment</p>
 *
 * <p>Description: Domain Object describing a MailAttachment entity</p>
 *
 */
@Entity (name="MailAttachment")
@Table (name="\"mail_attachment\"")
@NamedQueries ({
	 @NamedQuery(name="MailAttachment.findAll", query="SELECT mailattachment FROM MailAttachment mailattachment")
	,@NamedQuery(name="MailAttachment.findByAttachmentContent", query="SELECT mailattachment FROM MailAttachment mailattachment WHERE mailattachment.attachmentContent = :attachmentContent")
	,@NamedQuery(name="MailAttachment.findByAttachmentContentContaining", query="SELECT mailattachment FROM MailAttachment mailattachment WHERE mailattachment.attachmentContent like :attachmentContent")

	,@NamedQuery(name="MailAttachment.findByContentType", query="SELECT mailattachment FROM MailAttachment mailattachment WHERE mailattachment.contentType = :contentType")
	,@NamedQuery(name="MailAttachment.findByContentTypeContaining", query="SELECT mailattachment FROM MailAttachment mailattachment WHERE mailattachment.contentType like :contentType")

	,@NamedQuery(name="MailAttachment.findByFileName", query="SELECT mailattachment FROM MailAttachment mailattachment WHERE mailattachment.fileName = :fileName")
	,@NamedQuery(name="MailAttachment.findByFileNameContaining", query="SELECT mailattachment FROM MailAttachment mailattachment WHERE mailattachment.fileName like :fileName")

})

public class MailAttachment implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "MailAttachment.findAll";
    public static final String FIND_BY_ATTACHMENTCONTENT = "MailAttachment.findByAttachmentContent";
    public static final String FIND_BY_ATTACHMENTCONTENT_CONTAINING ="MailAttachment.findByAttachmentContentContaining";
    public static final String FIND_BY_CONTENTTYPE = "MailAttachment.findByContentType";
    public static final String FIND_BY_CONTENTTYPE_CONTAINING ="MailAttachment.findByContentTypeContaining";
    public static final String FIND_BY_FILENAME = "MailAttachment.findByFileName";
    public static final String FIND_BY_FILENAME_CONTAINING ="MailAttachment.findByFileNameContaining";
	
    @Id @Column(name="mail_attachment_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer mailAttachmentId;

//MP-MANAGED-ADDED-AREA-BEGINNING @attachment_content-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @attachment_content-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-attachment_content@
    @Column(name="attachment_content"   , nullable=true , unique=false)
    @Lob @Basic(fetch=FetchType.LAZY) 
    private String attachmentContent; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @content_type-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @content_type-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-content_type@
    @Column(name="content_type"  , length=30 , nullable=false , unique=false)
    private String contentType; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @file_name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @file_name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-file_name@
    @Column(name="file_name"  , length=64 , nullable=false , unique=false)
    private String fileName; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @m2m-mailContentViaMailContentMailAttachmentByMailContentId-mail_attachment@
    @ManyToMany
    @JoinTable(name="MAIL_CONTENT_MAIL_ATTACHMENT", 
        joinColumns=@JoinColumn(name="mail_attachment_id"), 
        inverseJoinColumns=@JoinColumn(name="mail_content_id") 
    )
    private Set <MailContent> mailContentViaMailContentMailAttachmentByMailContentId = new HashSet <MailContent> ();

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public MailAttachment() {
    }

	/**
	* All field constructor 
	*/
    public MailAttachment(
       Integer mailAttachmentId,
       String attachmentContent,
       String contentType,
       String fileName) {
	 this(
       mailAttachmentId,
       attachmentContent,
       contentType,
       fileName
	 ,true);
	}
    
	public MailAttachment(
       Integer mailAttachmentId,
       String attachmentContent,
       String contentType,
       String fileName	
    , boolean setRelationship) {
       //primary keys
       setMailAttachmentId (mailAttachmentId);
       //attributes
       setAttachmentContent (attachmentContent);
       setContentType (contentType);
       setFileName (fileName);
       //parents
    }

	public MailAttachment flat() {
	   return new MailAttachment(
          getMailAttachmentId(),
          getAttachmentContent(),
          getContentType(),
          getFileName()
       , false
	   );
	}

    public Integer getMailAttachmentId() {
        return mailAttachmentId;
    }
	
    public void setMailAttachmentId (Integer mailAttachmentId) {
        this.mailAttachmentId =  mailAttachmentId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-attachment_content@
    public String getAttachmentContent() {
        return attachmentContent;
    }
	
    public void setAttachmentContent (String attachmentContent) {
        this.attachmentContent =  attachmentContent;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-content_type@
    public String getContentType() {
        return contentType;
    }
	
    public void setContentType (String contentType) {
        this.contentType =  contentType;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-file_name@
    public String getFileName() {
        return fileName;
    }
	
    public void setFileName (String fileName) {
        this.fileName =  fileName;
    }
	
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @mailContentMailAttachmentViaMailAttachmentByMailAttachmentId-getter-mail_attachment@
//MP-MANAGED-UPDATABLE-ENDING

    public Set<MailContent> getMailContentViaMailContentMailAttachmentByMailContentId() {
        if (mailContentViaMailContentMailAttachmentByMailContentId == null){
            mailContentViaMailContentMailAttachmentByMailContentId = new HashSet<MailContent>();
        }
        return mailContentViaMailContentMailAttachmentByMailContentId;
    }

    public void setMailContentViaMailContentMailAttachmentByMailContentId (Set<MailContent> mailContentViaMailContentMailAttachmentByMailContentId) {
        this.mailContentViaMailContentMailAttachmentByMailContentId = mailContentViaMailContentMailAttachmentByMailContentId;
    }
    	
    public void addMailContentViaMailContentMailAttachmentByMailContentId (MailContent element) {
        getMailContentViaMailContentMailAttachmentByMailContentId().add(element);
    }
	


//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
