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

/**
 *
 * <p>Title: MailBatch</p>
 *
 * <p>Description: Domain Object describing a MailBatch entity</p>
 *
 */
@Entity (name="MailBatch")
@Table (name="\"mail_batch\"")
@NamedQueries ({
	 @NamedQuery(name="MailBatch.findAll", query="SELECT mailbatch FROM MailBatch mailbatch")
	,@NamedQuery(name="MailBatch.findByTitle", query="SELECT mailbatch FROM MailBatch mailbatch WHERE mailbatch.title = :title")
	,@NamedQuery(name="MailBatch.findByTitleContaining", query="SELECT mailbatch FROM MailBatch mailbatch WHERE mailbatch.title like :title")

	,@NamedQuery(name="MailBatch.findByStatus", query="SELECT mailbatch FROM MailBatch mailbatch WHERE mailbatch.status = :status")
	,@NamedQuery(name="MailBatch.findByStatusContaining", query="SELECT mailbatch FROM MailBatch mailbatch WHERE mailbatch.status like :status")

	,@NamedQuery(name="MailBatch.findByCreatedAt", query="SELECT mailbatch FROM MailBatch mailbatch WHERE mailbatch.createdAt = :createdAt")

	,@NamedQuery(name="MailBatch.findByCompletedAt", query="SELECT mailbatch FROM MailBatch mailbatch WHERE mailbatch.completedAt = :completedAt")

})

public class MailBatch implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "MailBatch.findAll";
    public static final String FIND_BY_TITLE = "MailBatch.findByTitle";
    public static final String FIND_BY_TITLE_CONTAINING ="MailBatch.findByTitleContaining";
    public static final String FIND_BY_STATUS = "MailBatch.findByStatus";
    public static final String FIND_BY_STATUS_CONTAINING ="MailBatch.findByStatusContaining";
    public static final String FIND_BY_CREATEDAT = "MailBatch.findByCreatedAt";
    public static final String FIND_BY_COMPLETEDAT = "MailBatch.findByCompletedAt";
	
    @Id @Column(name="mail_batch_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer mailBatchId;

//MP-MANAGED-ADDED-AREA-BEGINNING @title-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @title-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-title@
    @Column(name="title"  , length=200 , nullable=false , unique=false)
    private String title; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @status-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @status-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-status@
    @Column(name="status"  , length=25 , nullable=false , unique=false)
    private String status; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @created_at-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @created_at-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-created_at@
    @Column(name="created_at"   , nullable=false , unique=false)
    private Timestamp createdAt; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @completed_at-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @completed_at-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-completed_at@
    @Column(name="completed_at"   , nullable=true , unique=false)
    private Timestamp completedAt; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @mailAddressMailBatchViaMailBatchId-field-mail_batch@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.MailAddress.class, fetch=FetchType.LAZY, mappedBy="mailBatchId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <MailAddress> mailAddressMailBatchViaMailBatchId = new HashSet<MailAddress>(); 

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public MailBatch() {
    }

	/**
	* All field constructor 
	*/
    public MailBatch(
       Integer mailBatchId,
       String title,
       String status,
       Timestamp createdAt,
       Timestamp completedAt) {
	 this(
       mailBatchId,
       title,
       status,
       createdAt,
       completedAt
	 ,true);
	}
    
	public MailBatch(
       Integer mailBatchId,
       String title,
       String status,
       Timestamp createdAt,
       Timestamp completedAt	
    , boolean setRelationship) {
       //primary keys
       setMailBatchId (mailBatchId);
       //attributes
       setTitle (title);
       setStatus (status);
       setCreatedAt (createdAt);
       setCompletedAt (completedAt);
       //parents
    }

	public MailBatch flat() {
	   return new MailBatch(
          getMailBatchId(),
          getTitle(),
          getStatus(),
          getCreatedAt(),
          getCompletedAt()
       , false
	   );
	}

    public Integer getMailBatchId() {
        return mailBatchId;
    }
	
    public void setMailBatchId (Integer mailBatchId) {
        this.mailBatchId =  mailBatchId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-title@
    public String getTitle() {
        return title;
    }
	
    public void setTitle (String title) {
        this.title =  title;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-status@
    public String getStatus() {
        return status;
    }
	
    public void setStatus (String status) {
        this.status =  status;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-created_at@
    public Timestamp getCreatedAt() {
        return createdAt;
    }
	
    public void setCreatedAt (Timestamp createdAt) {
        this.createdAt =  createdAt;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-completed_at@
    public Timestamp getCompletedAt() {
        return completedAt;
    }
	
    public void setCompletedAt (Timestamp completedAt) {
        this.completedAt =  completedAt;
    }
	
//MP-MANAGED-UPDATABLE-ENDING



//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @mailAddressMailBatchViaMailBatchId-getter-mail_batch@
    public Set<MailAddress> getMailAddressMailBatchViaMailBatchId() {
        if (mailAddressMailBatchViaMailBatchId == null){
            mailAddressMailBatchViaMailBatchId = new HashSet<MailAddress>();
        }
        return mailAddressMailBatchViaMailBatchId;
    }

    public void setMailAddressMailBatchViaMailBatchId (Set<MailAddress> mailAddressMailBatchViaMailBatchId) {
        this.mailAddressMailBatchViaMailBatchId = mailAddressMailBatchViaMailBatchId;
    }	
    
    public void addMailAddressMailBatchViaMailBatchId (MailAddress element) {
    	    getMailAddressMailBatchViaMailBatchId().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-mail_batch@
    @javax.persistence.PrePersist
    public void prePersist_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-mail_batch@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
