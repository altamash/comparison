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
import defaultroot.defautmodel.domain.defautmodel.User;
import defaultroot.defautmodel.domain.defautmodel.User;

/**
 *
 * <p>Title: Job</p>
 *
 * <p>Description: Domain Object describing a Job entity</p>
 *
 */
@Entity (name="Job")
@Table (name="\"job\"")
@NamedQueries ({
	 @NamedQuery(name="Job.findAll", query="SELECT job FROM Job job")
	,@NamedQuery(name="Job.findByCronExpression", query="SELECT job FROM Job job WHERE job.cronExpression = :cronExpression")
	,@NamedQuery(name="Job.findByCronExpressionContaining", query="SELECT job FROM Job job WHERE job.cronExpression like :cronExpression")

	,@NamedQuery(name="Job.findByJobArea", query="SELECT job FROM Job job WHERE job.jobArea = :jobArea")
	,@NamedQuery(name="Job.findByJobAreaContaining", query="SELECT job FROM Job job WHERE job.jobArea like :jobArea")

	,@NamedQuery(name="Job.findByJobName", query="SELECT job FROM Job job WHERE job.jobName = :jobName")
	,@NamedQuery(name="Job.findByJobNameContaining", query="SELECT job FROM Job job WHERE job.jobName like :jobName")

	,@NamedQuery(name="Job.findByJobType", query="SELECT job FROM Job job WHERE job.jobType = :jobType")
	,@NamedQuery(name="Job.findByJobTypeContaining", query="SELECT job FROM Job job WHERE job.jobType like :jobType")

	,@NamedQuery(name="Job.findByCreatedAt", query="SELECT job FROM Job job WHERE job.createdAt = :createdAt")

	,@NamedQuery(name="Job.findByLastModified", query="SELECT job FROM Job job WHERE job.lastModified = :lastModified")

	,@NamedQuery(name="Job.findByNextFireTime", query="SELECT job FROM Job job WHERE job.nextFireTime = :nextFireTime")

})

public class Job implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Job.findAll";
    public static final String FIND_BY_CRONEXPRESSION = "Job.findByCronExpression";
    public static final String FIND_BY_CRONEXPRESSION_CONTAINING ="Job.findByCronExpressionContaining";
    public static final String FIND_BY_JOBAREA = "Job.findByJobArea";
    public static final String FIND_BY_JOBAREA_CONTAINING ="Job.findByJobAreaContaining";
    public static final String FIND_BY_JOBNAME = "Job.findByJobName";
    public static final String FIND_BY_JOBNAME_CONTAINING ="Job.findByJobNameContaining";
    public static final String FIND_BY_JOBTYPE = "Job.findByJobType";
    public static final String FIND_BY_JOBTYPE_CONTAINING ="Job.findByJobTypeContaining";
    public static final String FIND_BY_CREATEDAT = "Job.findByCreatedAt";
    public static final String FIND_BY_LASTMODIFIED = "Job.findByLastModified";
    public static final String FIND_BY_NEXTFIRETIME = "Job.findByNextFireTime";
	
    @Id @Column(name="job_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer jobId;

//MP-MANAGED-ADDED-AREA-BEGINNING @cron_expression-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @cron_expression-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-cron_expression@
    @Column(name="cron_expression"  , length=64 , nullable=true , unique=false)
    private String cronExpression; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @job_area-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @job_area-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-job_area@
    @Column(name="job_area"  , length=32 , nullable=true , unique=false)
    private String jobArea; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @job_name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @job_name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-job_name@
    @Column(name="job_name"  , length=64 , nullable=true , unique=false)
    private String jobName; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @job_type-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @job_type-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-job_type@
    @Column(name="job_type"  , length=32 , nullable=true , unique=false)
    private String jobType; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @created_at-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @created_at-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-created_at@
    @Column(name="created_at"   , nullable=false , unique=false)
    private Timestamp createdAt; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @last_modified-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @last_modified-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-last_modified@
    @Column(name="last_modified"   , nullable=false , unique=false)
    private Timestamp lastModified; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @next_fire_time-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @next_fire_time-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-next_fire_time@
    @Column(name="next_fire_time"   , nullable=true , unique=false)
    private Timestamp nextFireTime; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="created_by", referencedColumnName = "user_id" , nullable=false , unique=false , insertable=true, updatable=true) 
    private User createdBy;  

    @Column(name="created_by"  , nullable=false , unique=false, insertable=false, updatable=false)
    private Integer createdBy_;

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="modified_by", referencedColumnName = "user_id" , nullable=false , unique=false , insertable=true, updatable=true) 
    private User modifiedBy;  

    @Column(name="modified_by"  , nullable=false , unique=false, insertable=false, updatable=false)
    private Integer modifiedBy_;

    /**
    * Default constructor
    */
    public Job() {
    }

	/**
	* All field constructor 
	*/
    public Job(
       Integer jobId,
       String cronExpression,
       String jobArea,
       String jobName,
       String jobType,
       Integer createdBy,
       Integer modifiedBy,
       Timestamp createdAt,
       Timestamp lastModified,
       Timestamp nextFireTime) {
	 this(
       jobId,
       cronExpression,
       jobArea,
       jobName,
       jobType,
       createdBy,
       modifiedBy,
       createdAt,
       lastModified,
       nextFireTime
	 ,true);
	}
    
	public Job(
       Integer jobId,
       String cronExpression,
       String jobArea,
       String jobName,
       String jobType,
       Integer createdBy,
       Integer modifiedBy,
       Timestamp createdAt,
       Timestamp lastModified,
       Timestamp nextFireTime	
    , boolean setRelationship) {
       //primary keys
       setJobId (jobId);
       //attributes
       setCronExpression (cronExpression);
       setJobArea (jobArea);
       setJobName (jobName);
       setJobType (jobType);
       setCreatedAt (createdAt);
       setLastModified (lastModified);
       setNextFireTime (nextFireTime);
       //parents
       if (setRelationship) this.createdBy = new User();
       if (setRelationship) this.createdBy.setUserId(createdBy); 
	   setCreatedBy_ (createdBy);
       if (setRelationship) this.modifiedBy = new User();
       if (setRelationship) this.modifiedBy.setUserId(modifiedBy); 
	   setModifiedBy_ (modifiedBy);
    }

	public Job flat() {
	   return new Job(
          getJobId(),
          getCronExpression(),
          getJobArea(),
          getJobName(),
          getJobType(),
          getCreatedBy_(),
          getModifiedBy_(),
          getCreatedAt(),
          getLastModified(),
          getNextFireTime()
       , false
	   );
	}

    public Integer getJobId() {
        return jobId;
    }
	
    public void setJobId (Integer jobId) {
        this.jobId =  jobId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-cron_expression@
    public String getCronExpression() {
        return cronExpression;
    }
	
    public void setCronExpression (String cronExpression) {
        this.cronExpression =  cronExpression;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-job_area@
    public String getJobArea() {
        return jobArea;
    }
	
    public void setJobArea (String jobArea) {
        this.jobArea =  jobArea;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-job_name@
    public String getJobName() {
        return jobName;
    }
	
    public void setJobName (String jobName) {
        this.jobName =  jobName;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-job_type@
    public String getJobType() {
        return jobType;
    }
	
    public void setJobType (String jobType) {
        this.jobType =  jobType;
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

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-last_modified@
    public Timestamp getLastModified() {
        return lastModified;
    }
	
    public void setLastModified (Timestamp lastModified) {
        this.lastModified =  lastModified;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-next_fire_time@
    public Timestamp getNextFireTime() {
        return nextFireTime;
    }
	
    public void setNextFireTime (Timestamp nextFireTime) {
        this.nextFireTime =  nextFireTime;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public User getCreatedBy () {
    	return createdBy;
    }
	
    public void setCreatedBy (User createdBy) {
    	this.createdBy = createdBy;
    }

    public Integer getCreatedBy_() {
        return createdBy_;
    }
	
    public void setCreatedBy_ (Integer createdBy) {
        this.createdBy_ =  createdBy;
    }
	
    public User getModifiedBy () {
    	return modifiedBy;
    }
	
    public void setModifiedBy (User modifiedBy) {
    	this.modifiedBy = modifiedBy;
    }

    public Integer getModifiedBy_() {
        return modifiedBy_;
    }
	
    public void setModifiedBy_ (Integer modifiedBy) {
        this.modifiedBy_ =  modifiedBy;
    }
	


//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-job@
    @javax.persistence.PrePersist
    public void prePersist_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-job@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
