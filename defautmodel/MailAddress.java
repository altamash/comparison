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
	* - time      : 2015/08/04 AD at 17:45:42 PKT
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
import defaultroot.defautmodel.domain.defautmodel.User;
import defaultroot.defautmodel.domain.defautmodel.User;
import defaultroot.defautmodel.domain.defautmodel.MailBatch;

/**
 *
 * <p>Title: MailAddress</p>
 *
 * <p>Description: Domain Object describing a MailAddress entity</p>
 *
 */
@Entity (name="MailAddress")
@Table (name="\"mail_address\"")
@NamedQueries ({
	 @NamedQuery(name="MailAddress.findAll", query="SELECT mailaddress FROM MailAddress mailaddress")
	,@NamedQuery(name="MailAddress.findByRecipientMail", query="SELECT mailaddress FROM MailAddress mailaddress WHERE mailaddress.recipientMail = :recipientMail")
	,@NamedQuery(name="MailAddress.findByRecipientMailContaining", query="SELECT mailaddress FROM MailAddress mailaddress WHERE mailaddress.recipientMail like :recipientMail")

	,@NamedQuery(name="MailAddress.findByMailStatus", query="SELECT mailaddress FROM MailAddress mailaddress WHERE mailaddress.mailStatus = :mailStatus")
	,@NamedQuery(name="MailAddress.findByMailStatusContaining", query="SELECT mailaddress FROM MailAddress mailaddress WHERE mailaddress.mailStatus like :mailStatus")

	,@NamedQuery(name="MailAddress.findByRetries", query="SELECT mailaddress FROM MailAddress mailaddress WHERE mailaddress.retries = :retries")

	,@NamedQuery(name="MailAddress.findByPriority", query="SELECT mailaddress FROM MailAddress mailaddress WHERE mailaddress.priority = :priority")

	,@NamedQuery(name="MailAddress.findByQueuedAt", query="SELECT mailaddress FROM MailAddress mailaddress WHERE mailaddress.queuedAt = :queuedAt")

	,@NamedQuery(name="MailAddress.findByLastTriedAt", query="SELECT mailaddress FROM MailAddress mailaddress WHERE mailaddress.lastTriedAt = :lastTriedAt")

	,@NamedQuery(name="MailAddress.findBySentAt", query="SELECT mailaddress FROM MailAddress mailaddress WHERE mailaddress.sentAt = :sentAt")

	,@NamedQuery(name="MailAddress.findByOnHoldUntil", query="SELECT mailaddress FROM MailAddress mailaddress WHERE mailaddress.onHoldUntil = :onHoldUntil")

})

public class MailAddress implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "MailAddress.findAll";
    public static final String FIND_BY_RECIPIENTMAIL = "MailAddress.findByRecipientMail";
    public static final String FIND_BY_RECIPIENTMAIL_CONTAINING ="MailAddress.findByRecipientMailContaining";
    public static final String FIND_BY_MAILSTATUS = "MailAddress.findByMailStatus";
    public static final String FIND_BY_MAILSTATUS_CONTAINING ="MailAddress.findByMailStatusContaining";
    public static final String FIND_BY_RETRIES = "MailAddress.findByRetries";
    public static final String FIND_BY_PRIORITY = "MailAddress.findByPriority";
    public static final String FIND_BY_QUEUEDAT = "MailAddress.findByQueuedAt";
    public static final String FIND_BY_LASTTRIEDAT = "MailAddress.findByLastTriedAt";
    public static final String FIND_BY_SENTAT = "MailAddress.findBySentAt";
    public static final String FIND_BY_ONHOLDUNTIL = "MailAddress.findByOnHoldUntil";
	
    @Id @Column(name="mail_address_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer mailAddressId;

//MP-MANAGED-ADDED-AREA-BEGINNING @recipient_mail-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @recipient_mail-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-recipient_mail@
    @Column(name="recipient_mail"  , length=200 , nullable=true , unique=true)
    private String recipientMail; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @mail_status-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @mail_status-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-mail_status@
    @Column(name="mail_status"  , length=25 , nullable=true , unique=false)
    private String mailStatus; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @retries-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @retries-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-retries@
    @Column(name="retries"   , nullable=false , unique=false)
    private Integer retries; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @priority-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @priority-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-priority@
    @Column(name="priority"   , nullable=false , unique=false)
    private Integer priority; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @queued_at-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @queued_at-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-queued_at@
    @Column(name="queued_at"   , nullable=false , unique=false)
    private Timestamp queuedAt; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @last_tried_at-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @last_tried_at-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-last_tried_at@
    @Column(name="last_tried_at"   , nullable=true , unique=false)
    private Timestamp lastTriedAt; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @sent_at-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @sent_at-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-sent_at@
    @Column(name="sent_at"   , nullable=true , unique=false)
    private Timestamp sentAt; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @on_hold_until-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @on_hold_until-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-on_hold_until@
    @Column(name="on_hold_until"   , nullable=true , unique=false)
    private Timestamp onHoldUntil; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="mail_content_id", referencedColumnName = "mail_content_id" , nullable=false , unique=false , insertable=true, updatable=true) 
    private MailContent mailContentId;  

    @Column(name="mail_content_id"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer mailContentId_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="user_id_sender", referencedColumnName = "user_id" , nullable=true , unique=true  , insertable=true, updatable=true) 
    private User userIdSender;  

    @Column(name="user_id_sender"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer userIdSender_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="user_id_recipient", referencedColumnName = "user_id" , nullable=true , unique=true  , insertable=true, updatable=true) 
    private User userIdRecipient;  

    @Column(name="user_id_recipient"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer userIdRecipient_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="mail_batch_id", referencedColumnName = "mail_batch_id" , nullable=true , unique=true  , insertable=true, updatable=true) 
    private MailBatch mailBatchId;  

    @Column(name="mail_batch_id"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer mailBatchId_;

    /**
    * Default constructor
    */
    public MailAddress() {
    }

	/**
	* All field constructor 
	*/
    public MailAddress(
       Integer mailAddressId,
       Integer mailContentId,
       Integer mailBatchId,
       Integer userIdSender,
       Integer userIdRecipient,
       String recipientMail,
       String mailStatus,
       Integer retries,
       Integer priority,
       Timestamp queuedAt,
       Timestamp lastTriedAt,
       Timestamp sentAt,
       Timestamp onHoldUntil) {
	 this(
       mailAddressId,
       mailContentId,
       mailBatchId,
       userIdSender,
       userIdRecipient,
       recipientMail,
       mailStatus,
       retries,
       priority,
       queuedAt,
       lastTriedAt,
       sentAt,
       onHoldUntil
	 ,true);
	}
    
	public MailAddress(
       Integer mailAddressId,
       Integer mailContentId,
       Integer mailBatchId,
       Integer userIdSender,
       Integer userIdRecipient,
       String recipientMail,
       String mailStatus,
       Integer retries,
       Integer priority,
       Timestamp queuedAt,
       Timestamp lastTriedAt,
       Timestamp sentAt,
       Timestamp onHoldUntil	
    , boolean setRelationship) {
       //primary keys
       setMailAddressId (mailAddressId);
       //attributes
       setRecipientMail (recipientMail);
       setMailStatus (mailStatus);
       setRetries (retries);
       setPriority (priority);
       setQueuedAt (queuedAt);
       setLastTriedAt (lastTriedAt);
       setSentAt (sentAt);
       setOnHoldUntil (onHoldUntil);
       //parents
       if (setRelationship) this.mailContentId = new MailContent();
       if (setRelationship) this.mailContentId.setMailContentId(mailContentId); 
	   setMailContentId_ (mailContentId);
       if (setRelationship) this.userIdSender = new User();
       if (setRelationship) this.userIdSender.setUserId(userIdSender); 
	   setUserIdSender_ (userIdSender);
       if (setRelationship) this.userIdRecipient = new User();
       if (setRelationship) this.userIdRecipient.setUserId(userIdRecipient); 
	   setUserIdRecipient_ (userIdRecipient);
       if (setRelationship) this.mailBatchId = new MailBatch();
       if (setRelationship) this.mailBatchId.setMailBatchId(mailBatchId); 
	   setMailBatchId_ (mailBatchId);
    }

	public MailAddress flat() {
	   return new MailAddress(
          getMailAddressId(),
          getMailContentId_(),
          getMailBatchId_(),
          getUserIdSender_(),
          getUserIdRecipient_(),
          getRecipientMail(),
          getMailStatus(),
          getRetries(),
          getPriority(),
          getQueuedAt(),
          getLastTriedAt(),
          getSentAt(),
          getOnHoldUntil()
       , false
	   );
	}

    public Integer getMailAddressId() {
        return mailAddressId;
    }
	
    public void setMailAddressId (Integer mailAddressId) {
        this.mailAddressId =  mailAddressId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-recipient_mail@
    public String getRecipientMail() {
        return recipientMail;
    }
	
    public void setRecipientMail (String recipientMail) {
        this.recipientMail =  recipientMail;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-mail_status@
    public String getMailStatus() {
        return mailStatus;
    }
	
    public void setMailStatus (String mailStatus) {
        this.mailStatus =  mailStatus;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-retries@
    public Integer getRetries() {
        return retries;
    }
	
    public void setRetries (Integer retries) {
        this.retries =  retries;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-priority@
    public Integer getPriority() {
        return priority;
    }
	
    public void setPriority (Integer priority) {
        this.priority =  priority;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-queued_at@
    public Timestamp getQueuedAt() {
        return queuedAt;
    }
	
    public void setQueuedAt (Timestamp queuedAt) {
        this.queuedAt =  queuedAt;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-last_tried_at@
    public Timestamp getLastTriedAt() {
        return lastTriedAt;
    }
	
    public void setLastTriedAt (Timestamp lastTriedAt) {
        this.lastTriedAt =  lastTriedAt;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-sent_at@
    public Timestamp getSentAt() {
        return sentAt;
    }
	
    public void setSentAt (Timestamp sentAt) {
        this.sentAt =  sentAt;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-on_hold_until@
    public Timestamp getOnHoldUntil() {
        return onHoldUntil;
    }
	
    public void setOnHoldUntil (Timestamp onHoldUntil) {
        this.onHoldUntil =  onHoldUntil;
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
	
    public User getUserIdSender () {
    	return userIdSender;
    }
	
    public void setUserIdSender (User userIdSender) {
    	this.userIdSender = userIdSender;
    }

    public Integer getUserIdSender_() {
        return userIdSender_;
    }
	
    public void setUserIdSender_ (Integer userIdSender) {
        this.userIdSender_ =  userIdSender;
    }
	
    public User getUserIdRecipient () {
    	return userIdRecipient;
    }
	
    public void setUserIdRecipient (User userIdRecipient) {
    	this.userIdRecipient = userIdRecipient;
    }

    public Integer getUserIdRecipient_() {
        return userIdRecipient_;
    }
	
    public void setUserIdRecipient_ (Integer userIdRecipient) {
        this.userIdRecipient_ =  userIdRecipient;
    }
	
    public MailBatch getMailBatchId () {
    	return mailBatchId;
    }
	
    public void setMailBatchId (MailBatch mailBatchId) {
    	this.mailBatchId = mailBatchId;
    }

    public Integer getMailBatchId_() {
        return mailBatchId_;
    }
	
    public void setMailBatchId_ (Integer mailBatchId) {
        this.mailBatchId_ =  mailBatchId;
    }
	


//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-mail_address@
    @javax.persistence.PrePersist
    public void prePersist_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-mail_address@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
