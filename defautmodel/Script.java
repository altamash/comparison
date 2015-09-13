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
import defaultroot.defautmodel.domain.defautmodel.Language;
import defaultroot.defautmodel.domain.defautmodel.Price;
import defaultroot.defautmodel.domain.defautmodel.Rating;
import defaultroot.defautmodel.domain.defautmodel.Rating;
import defaultroot.defautmodel.domain.defautmodel.Rating;
import defaultroot.defautmodel.domain.defautmodel.User;
import defaultroot.defautmodel.domain.defautmodel.Translation;
import defaultroot.defautmodel.domain.defautmodel.Competence;

/**
 *
 * <p>Title: Script</p>
 *
 * <p>Description: Domain Object describing a Script entity</p>
 *
 */
@Entity (name="Script")
@Table (name="\"script\"")
@NamedQueries ({
	 @NamedQuery(name="Script.findAll", query="SELECT script FROM Script script")
	,@NamedQuery(name="Script.findByScriptType", query="SELECT script FROM Script script WHERE script.scriptType = :scriptType")
	,@NamedQuery(name="Script.findByScriptTypeContaining", query="SELECT script FROM Script script WHERE script.scriptType like :scriptType")

	,@NamedQuery(name="Script.findByScriptStatus", query="SELECT script FROM Script script WHERE script.scriptStatus = :scriptStatus")
	,@NamedQuery(name="Script.findByScriptStatusContaining", query="SELECT script FROM Script script WHERE script.scriptStatus like :scriptStatus")

	,@NamedQuery(name="Script.findByPriority", query="SELECT script FROM Script script WHERE script.priority = :priority")

	,@NamedQuery(name="Script.findByDeadline", query="SELECT script FROM Script script WHERE script.deadline = :deadline")

	,@NamedQuery(name="Script.findByLengthWordsRequest", query="SELECT script FROM Script script WHERE script.lengthWordsRequest = :lengthWordsRequest")

	,@NamedQuery(name="Script.findByLengthMinutesRequest", query="SELECT script FROM Script script WHERE script.lengthMinutesRequest = :lengthMinutesRequest")

	,@NamedQuery(name="Script.findByLengthWordsResult", query="SELECT script FROM Script script WHERE script.lengthWordsResult = :lengthWordsResult")

	,@NamedQuery(name="Script.findByLengthMinutesResult", query="SELECT script FROM Script script WHERE script.lengthMinutesResult = :lengthMinutesResult")

	,@NamedQuery(name="Script.findByScriptRequest", query="SELECT script FROM Script script WHERE script.scriptRequest = :scriptRequest")
	,@NamedQuery(name="Script.findByScriptRequestContaining", query="SELECT script FROM Script script WHERE script.scriptRequest like :scriptRequest")

	,@NamedQuery(name="Script.findByScriptResult", query="SELECT script FROM Script script WHERE script.scriptResult = :scriptResult")
	,@NamedQuery(name="Script.findByScriptResultContaining", query="SELECT script FROM Script script WHERE script.scriptResult like :scriptResult")

})

public class Script implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Script.findAll";
    public static final String FIND_BY_SCRIPTTYPE = "Script.findByScriptType";
    public static final String FIND_BY_SCRIPTTYPE_CONTAINING ="Script.findByScriptTypeContaining";
    public static final String FIND_BY_SCRIPTSTATUS = "Script.findByScriptStatus";
    public static final String FIND_BY_SCRIPTSTATUS_CONTAINING ="Script.findByScriptStatusContaining";
    public static final String FIND_BY_PRIORITY = "Script.findByPriority";
    public static final String FIND_BY_DEADLINE = "Script.findByDeadline";
    public static final String FIND_BY_LENGTHWORDSREQUEST = "Script.findByLengthWordsRequest";
    public static final String FIND_BY_LENGTHMINUTESREQUEST = "Script.findByLengthMinutesRequest";
    public static final String FIND_BY_LENGTHWORDSRESULT = "Script.findByLengthWordsResult";
    public static final String FIND_BY_LENGTHMINUTESRESULT = "Script.findByLengthMinutesResult";
    public static final String FIND_BY_SCRIPTREQUEST = "Script.findByScriptRequest";
    public static final String FIND_BY_SCRIPTREQUEST_CONTAINING ="Script.findByScriptRequestContaining";
    public static final String FIND_BY_SCRIPTRESULT = "Script.findByScriptResult";
    public static final String FIND_BY_SCRIPTRESULT_CONTAINING ="Script.findByScriptResultContaining";
	
    @Id @Column(name="script_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer scriptId;

//MP-MANAGED-ADDED-AREA-BEGINNING @script_type-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @script_type-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-script_type@
    @Column(name="script_type"  , length=10 , nullable=false , unique=false)
    private String scriptType; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @script_status-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @script_status-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-script_status@
    @Column(name="script_status"  , length=30 , nullable=false , unique=false)
    private String scriptStatus; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @priority-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @priority-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-priority@
    @Column(name="priority"   , nullable=false , unique=false)
    private Boolean priority; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @deadline-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @deadline-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-deadline@
    @Column(name="deadline"   , nullable=true , unique=false)
    private Timestamp deadline; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @length_words_request-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @length_words_request-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-length_words_request@
    @Column(name="length_words_request"   , nullable=true , unique=false)
    private Integer lengthWordsRequest; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @length_minutes_request-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @length_minutes_request-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-length_minutes_request@
    @Column(name="length_minutes_request"   , nullable=true , unique=false)
    private Integer lengthMinutesRequest; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @length_words_result-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @length_words_result-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-length_words_result@
    @Column(name="length_words_result"   , nullable=true , unique=false)
    private Integer lengthWordsResult; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @length_minutes_result-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @length_minutes_result-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-length_minutes_result@
    @Column(name="length_minutes_result"   , nullable=true , unique=false)
    private Integer lengthMinutesResult; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @script_request-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @script_request-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-script_request@
    @Column(name="script_request"   , nullable=false , unique=false)
    @Lob @Basic(fetch=FetchType.LAZY) 
    private String scriptRequest; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @script_result-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @script_result-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-script_result@
    @Column(name="script_result"   , nullable=false , unique=false)
    @Lob @Basic(fetch=FetchType.LAZY) 
    private String scriptResult; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="client_id", referencedColumnName = "user_id" , nullable=false , unique=false , insertable=true, updatable=true) 
    private User clientId;  

    @Column(name="client_id"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer clientId_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="iso6392t", referencedColumnName = "iso6392t" , nullable=true , unique=true  , insertable=true, updatable=true) 
    private Language iso6392t;  

    @Column(name="iso6392t" , length=3 , nullable=true , unique=true, insertable=false, updatable=false)
    private String iso6392t_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="price_id", referencedColumnName = "price_id" , nullable=true , unique=true  , insertable=true, updatable=true) 
    private Price priceId;  

    @Column(name="price_id"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer priceId_;

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="rating_id_client", referencedColumnName = "rating_id" , nullable=false , unique=true  , insertable=true, updatable=true) 
    private Rating ratingIdClient;  

    @Column(name="rating_id_client"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer ratingIdClient_;

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="rating_id_request", referencedColumnName = "rating_id" , nullable=false , unique=true  , insertable=true, updatable=true) 
    private Rating ratingIdRequest;  

    @Column(name="rating_id_request"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer ratingIdRequest_;

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="rating_id_scriptor", referencedColumnName = "rating_id" , nullable=false , unique=true  , insertable=true, updatable=true) 
    private Rating ratingIdScriptor;  

    @Column(name="rating_id_scriptor"  , nullable=false , unique=true, insertable=false, updatable=false)
    private Integer ratingIdScriptor_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="scriptor_id", referencedColumnName = "user_id" , nullable=true , unique=true  , insertable=true, updatable=true) 
    private User scriptorId;  

    @Column(name="scriptor_id"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer scriptorId_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="translation_id", referencedColumnName = "translation_id" , nullable=true , unique=true  , insertable=true, updatable=true) 
    private Translation translationId;  

    @Column(name="translation_id"  , nullable=true , unique=true, insertable=false, updatable=false)
    private Integer translationId_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @m2m-competenceViaScriptCompetenceByCompetenceId-script@
    @ManyToMany
    @JoinTable(name="SCRIPT_COMPETENCE", 
        joinColumns=@JoinColumn(name="script_id"), 
        inverseJoinColumns=@JoinColumn(name="competence_id") 
    )
    private Set <Competence> competenceViaScriptCompetenceByCompetenceId = new HashSet <Competence> ();

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public Script() {
    }

	/**
	* All field constructor 
	*/
    public Script(
       Integer scriptId,
       Integer clientId,
       Integer scriptorId,
       String iso6392t,
       Integer translationId,
       Integer ratingIdRequest,
       Integer ratingIdScriptor,
       Integer ratingIdClient,
       Integer priceId,
       String scriptType,
       String scriptStatus,
       Boolean priority,
       Timestamp deadline,
       Integer lengthWordsRequest,
       Integer lengthMinutesRequest,
       Integer lengthWordsResult,
       Integer lengthMinutesResult,
       String scriptRequest,
       String scriptResult) {
	 this(
       scriptId,
       clientId,
       scriptorId,
       iso6392t,
       translationId,
       ratingIdRequest,
       ratingIdScriptor,
       ratingIdClient,
       priceId,
       scriptType,
       scriptStatus,
       priority,
       deadline,
       lengthWordsRequest,
       lengthMinutesRequest,
       lengthWordsResult,
       lengthMinutesResult,
       scriptRequest,
       scriptResult
	 ,true);
	}
    
	public Script(
       Integer scriptId,
       Integer clientId,
       Integer scriptorId,
       String iso6392t,
       Integer translationId,
       Integer ratingIdRequest,
       Integer ratingIdScriptor,
       Integer ratingIdClient,
       Integer priceId,
       String scriptType,
       String scriptStatus,
       Boolean priority,
       Timestamp deadline,
       Integer lengthWordsRequest,
       Integer lengthMinutesRequest,
       Integer lengthWordsResult,
       Integer lengthMinutesResult,
       String scriptRequest,
       String scriptResult	
    , boolean setRelationship) {
       //primary keys
       setScriptId (scriptId);
       //attributes
       setScriptType (scriptType);
       setScriptStatus (scriptStatus);
       setPriority (priority);
       setDeadline (deadline);
       setLengthWordsRequest (lengthWordsRequest);
       setLengthMinutesRequest (lengthMinutesRequest);
       setLengthWordsResult (lengthWordsResult);
       setLengthMinutesResult (lengthMinutesResult);
       setScriptRequest (scriptRequest);
       setScriptResult (scriptResult);
       //parents
       if (setRelationship) this.clientId = new User();
       if (setRelationship) this.clientId.setUserId(clientId); 
	   setClientId_ (clientId);
       if (setRelationship) this.iso6392t = new Language();
       if (setRelationship) this.iso6392t.setIso6392t(iso6392t); 
	   setIso6392t_ (iso6392t);
       if (setRelationship) this.priceId = new Price();
       if (setRelationship) this.priceId.setPriceId(priceId); 
	   setPriceId_ (priceId);
       if (setRelationship) this.ratingIdClient = new Rating();
       if (setRelationship) this.ratingIdClient.setRatingId(ratingIdClient); 
	   setRatingIdClient_ (ratingIdClient);
       if (setRelationship) this.ratingIdRequest = new Rating();
       if (setRelationship) this.ratingIdRequest.setRatingId(ratingIdRequest); 
	   setRatingIdRequest_ (ratingIdRequest);
       if (setRelationship) this.ratingIdScriptor = new Rating();
       if (setRelationship) this.ratingIdScriptor.setRatingId(ratingIdScriptor); 
	   setRatingIdScriptor_ (ratingIdScriptor);
       if (setRelationship) this.scriptorId = new User();
       if (setRelationship) this.scriptorId.setUserId(scriptorId); 
	   setScriptorId_ (scriptorId);
       if (setRelationship) this.translationId = new Translation();
       if (setRelationship) this.translationId.setTranslationId(translationId); 
	   setTranslationId_ (translationId);
    }

	public Script flat() {
	   return new Script(
          getScriptId(),
          getClientId_(),
          getScriptorId_(),
          getIso6392t_(),
          getTranslationId_(),
          getRatingIdRequest_(),
          getRatingIdScriptor_(),
          getRatingIdClient_(),
          getPriceId_(),
          getScriptType(),
          getScriptStatus(),
          getPriority(),
          getDeadline(),
          getLengthWordsRequest(),
          getLengthMinutesRequest(),
          getLengthWordsResult(),
          getLengthMinutesResult(),
          getScriptRequest(),
          getScriptResult()
       , false
	   );
	}

    public Integer getScriptId() {
        return scriptId;
    }
	
    public void setScriptId (Integer scriptId) {
        this.scriptId =  scriptId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-script_type@
    public String getScriptType() {
        return scriptType;
    }
	
    public void setScriptType (String scriptType) {
        this.scriptType =  scriptType;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-script_status@
    public String getScriptStatus() {
        return scriptStatus;
    }
	
    public void setScriptStatus (String scriptStatus) {
        this.scriptStatus =  scriptStatus;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-priority@
    public Boolean getPriority() {
        return priority;
    }
	
    public void setPriority (Boolean priority) {
        this.priority =  priority;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-deadline@
    public Timestamp getDeadline() {
        return deadline;
    }
	
    public void setDeadline (Timestamp deadline) {
        this.deadline =  deadline;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-length_words_request@
    public Integer getLengthWordsRequest() {
        return lengthWordsRequest;
    }
	
    public void setLengthWordsRequest (Integer lengthWordsRequest) {
        this.lengthWordsRequest =  lengthWordsRequest;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-length_minutes_request@
    public Integer getLengthMinutesRequest() {
        return lengthMinutesRequest;
    }
	
    public void setLengthMinutesRequest (Integer lengthMinutesRequest) {
        this.lengthMinutesRequest =  lengthMinutesRequest;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-length_words_result@
    public Integer getLengthWordsResult() {
        return lengthWordsResult;
    }
	
    public void setLengthWordsResult (Integer lengthWordsResult) {
        this.lengthWordsResult =  lengthWordsResult;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-length_minutes_result@
    public Integer getLengthMinutesResult() {
        return lengthMinutesResult;
    }
	
    public void setLengthMinutesResult (Integer lengthMinutesResult) {
        this.lengthMinutesResult =  lengthMinutesResult;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-script_request@
    public String getScriptRequest() {
        return scriptRequest;
    }
	
    public void setScriptRequest (String scriptRequest) {
        this.scriptRequest =  scriptRequest;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-script_result@
    public String getScriptResult() {
        return scriptResult;
    }
	
    public void setScriptResult (String scriptResult) {
        this.scriptResult =  scriptResult;
    }
	
//MP-MANAGED-UPDATABLE-ENDING


    public User getClientId () {
    	return clientId;
    }
	
    public void setClientId (User clientId) {
    	this.clientId = clientId;
    }

    public Integer getClientId_() {
        return clientId_;
    }
	
    public void setClientId_ (Integer clientId) {
        this.clientId_ =  clientId;
    }
	
    public Language getIso6392t () {
    	return iso6392t;
    }
	
    public void setIso6392t (Language iso6392t) {
    	this.iso6392t = iso6392t;
    }

    public String getIso6392t_() {
        return iso6392t_;
    }
	
    public void setIso6392t_ (String iso6392t) {
        this.iso6392t_ =  iso6392t;
    }
	
    public Price getPriceId () {
    	return priceId;
    }
	
    public void setPriceId (Price priceId) {
    	this.priceId = priceId;
    }

    public Integer getPriceId_() {
        return priceId_;
    }
	
    public void setPriceId_ (Integer priceId) {
        this.priceId_ =  priceId;
    }
	
    public Rating getRatingIdClient () {
    	return ratingIdClient;
    }
	
    public void setRatingIdClient (Rating ratingIdClient) {
    	this.ratingIdClient = ratingIdClient;
    }

    public Integer getRatingIdClient_() {
        return ratingIdClient_;
    }
	
    public void setRatingIdClient_ (Integer ratingIdClient) {
        this.ratingIdClient_ =  ratingIdClient;
    }
	
    public Rating getRatingIdRequest () {
    	return ratingIdRequest;
    }
	
    public void setRatingIdRequest (Rating ratingIdRequest) {
    	this.ratingIdRequest = ratingIdRequest;
    }

    public Integer getRatingIdRequest_() {
        return ratingIdRequest_;
    }
	
    public void setRatingIdRequest_ (Integer ratingIdRequest) {
        this.ratingIdRequest_ =  ratingIdRequest;
    }
	
    public Rating getRatingIdScriptor () {
    	return ratingIdScriptor;
    }
	
    public void setRatingIdScriptor (Rating ratingIdScriptor) {
    	this.ratingIdScriptor = ratingIdScriptor;
    }

    public Integer getRatingIdScriptor_() {
        return ratingIdScriptor_;
    }
	
    public void setRatingIdScriptor_ (Integer ratingIdScriptor) {
        this.ratingIdScriptor_ =  ratingIdScriptor;
    }
	
    public User getScriptorId () {
    	return scriptorId;
    }
	
    public void setScriptorId (User scriptorId) {
    	this.scriptorId = scriptorId;
    }

    public Integer getScriptorId_() {
        return scriptorId_;
    }
	
    public void setScriptorId_ (Integer scriptorId) {
        this.scriptorId_ =  scriptorId;
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
	

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scriptCompetenceViaScriptByScriptId-getter-script@
//MP-MANAGED-UPDATABLE-ENDING

    public Set<Competence> getCompetenceViaScriptCompetenceByCompetenceId() {
        if (competenceViaScriptCompetenceByCompetenceId == null){
            competenceViaScriptCompetenceByCompetenceId = new HashSet<Competence>();
        }
        return competenceViaScriptCompetenceByCompetenceId;
    }

    public void setCompetenceViaScriptCompetenceByCompetenceId (Set<Competence> competenceViaScriptCompetenceByCompetenceId) {
        this.competenceViaScriptCompetenceByCompetenceId = competenceViaScriptCompetenceByCompetenceId;
    }
    	
    public void addCompetenceViaScriptCompetenceByCompetenceId (Competence element) {
        getCompetenceViaScriptCompetenceByCompetenceId().add(element);
    }
	
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-script@
    @javax.persistence.PrePersist
    public void prePersist_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-script@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
