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
	* - time      : 2015/08/04 AD at 17:45:43 PKT
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
import defaultroot.defautmodel.domain.defautmodel.Translation;
import defaultroot.defautmodel.domain.defautmodel.TranslationSkillId;

/**
 *
 * <p>Title: TranslationSkill</p>
 *
 * <p>Description: Domain Object describing a TranslationSkill entity</p>
 *
 */
@Entity (name="TranslationSkill")
@Table (name="\"translation_skill\"")
@NamedQueries ({
	 @NamedQuery(name="TranslationSkill.findAll", query="SELECT translationskill FROM TranslationSkill translationskill")
	,@NamedQuery(name="TranslationSkill.findByRatingAverage", query="SELECT translationskill FROM TranslationSkill translationskill WHERE translationskill.ratingAverage = :ratingAverage")

	,@NamedQuery(name="TranslationSkill.findByScriptAmount", query="SELECT translationskill FROM TranslationSkill translationskill WHERE translationskill.scriptAmount = :scriptAmount")

	,@NamedQuery(name="TranslationSkill.findByIsSupervisor", query="SELECT translationskill FROM TranslationSkill translationskill WHERE translationskill.isSupervisor = :isSupervisor")

})

public class TranslationSkill implements Serializable {
    private static final long serialVersionUID = 1L;
	public static final Long __DEFAULT_RATING_AVERAGE = Long.valueOf(0);
	public static final Integer __DEFAULT_SCRIPT_AMOUNT = Integer.valueOf(0);

    public static final String FIND_ALL = "TranslationSkill.findAll";
    public static final String FIND_BY_RATINGAVERAGE = "TranslationSkill.findByRatingAverage";
    public static final String FIND_BY_SCRIPTAMOUNT = "TranslationSkill.findByScriptAmount";
    public static final String FIND_BY_ISSUPERVISOR = "TranslationSkill.findByIsSupervisor";
	
    @EmbeddedId
    private TranslationSkillId translationSkillId__;
//MP-MANAGED-ADDED-AREA-BEGINNING @rating_average-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @rating_average-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-rating_average@
    @Column(name="rating_average"   , nullable=false , unique=true)
    private Long ratingAverage; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @script_amount-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @script_amount-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-script_amount@
    @Column(name="script_amount"   , nullable=false , unique=false)
    private Integer scriptAmount; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @is_supervisor-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @is_supervisor-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-is_supervisor@
    @Column(name="is_supervisor"   , nullable=false , unique=false)
    private Boolean isSupervisor; 
//MP-MANAGED-UPDATABLE-ENDING

    @MapsId ("user_id")
    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="user_id", referencedColumnName = "user_id" , nullable=false , unique=false , insertable=true, updatable=true) 
    private User userId;  

    @Column(name="user_id"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer userId_;

    @MapsId ("translation_id")
    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="translation_id", referencedColumnName = "translation_id" , nullable=false , unique=true  , insertable=true, updatable=true) 
    private Translation translationId;  

    @Column(name="translation_id"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer translationId_;

    /**
    * Default constructor
    */
    public TranslationSkill() {
    }

	/**
	* All field constructor 
	*/
    public TranslationSkill(
       Integer userId,
       Integer translationId,
       Long ratingAverage,
       Integer scriptAmount,
       Boolean isSupervisor) {
	 this(
       userId,
       translationId,
       ratingAverage,
       scriptAmount,
       isSupervisor
	 ,true);
	}
    
	public TranslationSkill(
       Integer userId,
       Integer translationId,
       Long ratingAverage,
       Integer scriptAmount,
       Boolean isSupervisor	
    , boolean setRelationship) {
       //primary keys
       this.translationSkillId__ = new TranslationSkillId();  	
       //attributes
       setRatingAverage (ratingAverage);
       setScriptAmount (scriptAmount);
       setIsSupervisor (isSupervisor);
       //parents
       if (setRelationship) this.userId = new User();
       if (setRelationship) this.userId.setUserId(userId); 
	   setUserId_ (userId);
       if (setRelationship) this.translationId = new Translation();
       if (setRelationship) this.translationId.setTranslationId(translationId); 
	   setTranslationId_ (translationId);
    }

	public TranslationSkill flat() {
	   return new TranslationSkill(
		  getTranslationSkillId__().getUserId(),
		  getTranslationSkillId__().getTranslationId(),
          getRatingAverage(),
          getScriptAmount(),
          getIsSupervisor()
       , false
	   );
	}


    public TranslationSkillId getTranslationSkillId__() {
		if (translationSkillId__==null) translationSkillId__ = new TranslationSkillId();
        return translationSkillId__;
    }
	
    public void setTranslationSkillId__ (TranslationSkillId translationSkillId__) {
        this.translationSkillId__ =  translationSkillId__;
    }
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-rating_average@
    public Long getRatingAverage() {
        return ratingAverage;
    }
	
    public void setRatingAverage (Long ratingAverage) {
        this.ratingAverage =  ratingAverage;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-script_amount@
    public Integer getScriptAmount() {
        return scriptAmount;
    }
	
    public void setScriptAmount (Integer scriptAmount) {
        this.scriptAmount =  scriptAmount;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-is_supervisor@
    public Boolean getIsSupervisor() {
        return isSupervisor;
    }
	
    public void setIsSupervisor (Boolean isSupervisor) {
        this.isSupervisor =  isSupervisor;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public User getUserId () {
    	return userId;
    }
	
    public void setUserId (User userId) {
    	this.userId = userId;
    }

    public Integer getUserId_() {
        return userId_;
    }
	
    public void setUserId_ (Integer userId) {
        this.userId_ =  userId;
    }
	
    public Translation getTranslationId () {
    	return translationId;
    }
	
    public void setTranslationId (Translation translationId) {
    	this.translationId = translationId;
    }

    public Integer getTranslationId_() {
        return translationId_;
    }
	
    public void setTranslationId_ (Integer translationId) {
        this.translationId_ =  translationId;
    }
	


//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-translation_skill@
    @javax.persistence.PrePersist
    public void prePersist_ () {
        if (ratingAverage==null) ratingAverage=__DEFAULT_RATING_AVERAGE;
        if (scriptAmount==null) scriptAmount=__DEFAULT_SCRIPT_AMOUNT;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-translation_skill@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
        if (ratingAverage==null) ratingAverage=__DEFAULT_RATING_AVERAGE;
        if (scriptAmount==null) scriptAmount=__DEFAULT_SCRIPT_AMOUNT;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
