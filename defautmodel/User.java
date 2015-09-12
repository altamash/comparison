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
import defaultroot.defautmodel.domain.defautmodel.LanguageSkill;
import defaultroot.defautmodel.domain.defautmodel.MailAddress;
import defaultroot.defautmodel.domain.defautmodel.MailAddress;
import defaultroot.defautmodel.domain.defautmodel.Revinfo;
import defaultroot.defautmodel.domain.defautmodel.Script;
import defaultroot.defautmodel.domain.defautmodel.Script;
import defaultroot.defautmodel.domain.defautmodel.TranslationSkill;
import defaultroot.defautmodel.domain.defautmodel.Language;
import defaultroot.defautmodel.domain.defautmodel.Country;
import defaultroot.defautmodel.domain.defautmodel.App;
import defaultroot.defautmodel.domain.defautmodel.Competence;
import defaultroot.defautmodel.domain.defautmodel.Role;

/**
 *
 * <p>Title: User</p>
 *
 * <p>Description: Domain Object describing a User entity</p>
 *
 */
@Entity (name="User")
@Table (name="\"user\"")
@NamedQueries ({
	 @NamedQuery(name="User.findAll", query="SELECT user FROM User user")
	,@NamedQuery(name="User.findBySalutation", query="SELECT user FROM User user WHERE user.salutation = :salutation")
	,@NamedQuery(name="User.findBySalutationContaining", query="SELECT user FROM User user WHERE user.salutation like :salutation")

	,@NamedQuery(name="User.findByFirstName", query="SELECT user FROM User user WHERE user.firstName = :firstName")
	,@NamedQuery(name="User.findByFirstNameContaining", query="SELECT user FROM User user WHERE user.firstName like :firstName")

	,@NamedQuery(name="User.findByLastName", query="SELECT user FROM User user WHERE user.lastName = :lastName")
	,@NamedQuery(name="User.findByLastNameContaining", query="SELECT user FROM User user WHERE user.lastName like :lastName")

	,@NamedQuery(name="User.findByEmail", query="SELECT user FROM User user WHERE user.email = :email")
	,@NamedQuery(name="User.findByEmailContaining", query="SELECT user FROM User user WHERE user.email like :email")

	,@NamedQuery(name="User.findByStreet", query="SELECT user FROM User user WHERE user.street = :street")
	,@NamedQuery(name="User.findByStreetContaining", query="SELECT user FROM User user WHERE user.street like :street")

	,@NamedQuery(name="User.findByPostalCode", query="SELECT user FROM User user WHERE user.postalCode = :postalCode")
	,@NamedQuery(name="User.findByPostalCodeContaining", query="SELECT user FROM User user WHERE user.postalCode like :postalCode")

	,@NamedQuery(name="User.findByCity", query="SELECT user FROM User user WHERE user.city = :city")
	,@NamedQuery(name="User.findByCityContaining", query="SELECT user FROM User user WHERE user.city like :city")

	,@NamedQuery(name="User.findByPassword", query="SELECT user FROM User user WHERE user.password = :password")
	,@NamedQuery(name="User.findByPasswordContaining", query="SELECT user FROM User user WHERE user.password like :password")

	,@NamedQuery(name="User.findByInitialUserType", query="SELECT user FROM User user WHERE user.initialUserType = :initialUserType")
	,@NamedQuery(name="User.findByInitialUserTypeContaining", query="SELECT user FROM User user WHERE user.initialUserType like :initialUserType")

	,@NamedQuery(name="User.findByRegistrationLink", query="SELECT user FROM User user WHERE user.registrationLink = :registrationLink")
	,@NamedQuery(name="User.findByRegistrationLinkContaining", query="SELECT user FROM User user WHERE user.registrationLink like :registrationLink")

	,@NamedQuery(name="User.findByHost", query="SELECT user FROM User user WHERE user.host = :host")
	,@NamedQuery(name="User.findByHostContaining", query="SELECT user FROM User user WHERE user.host like :host")

	,@NamedQuery(name="User.findByIp", query="SELECT user FROM User user WHERE user.ip = :ip")
	,@NamedQuery(name="User.findByIpContaining", query="SELECT user FROM User user WHERE user.ip like :ip")

	,@NamedQuery(name="User.findByAcceptedTacScriptor", query="SELECT user FROM User user WHERE user.acceptedTacScriptor = :acceptedTacScriptor")

	,@NamedQuery(name="User.findByAcceptedTacClient", query="SELECT user FROM User user WHERE user.acceptedTacClient = :acceptedTacClient")

	,@NamedQuery(name="User.findByIsActive", query="SELECT user FROM User user WHERE user.isActive = :isActive")

	,@NamedQuery(name="User.findByIsDeleted", query="SELECT user FROM User user WHERE user.isDeleted = :isDeleted")

	,@NamedQuery(name="User.findByCreatedAt", query="SELECT user FROM User user WHERE user.createdAt = :createdAt")

})

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "User.findAll";
    public static final String FIND_BY_SALUTATION = "User.findBySalutation";
    public static final String FIND_BY_SALUTATION_CONTAINING ="User.findBySalutationContaining";
    public static final String FIND_BY_FIRSTNAME = "User.findByFirstName";
    public static final String FIND_BY_FIRSTNAME_CONTAINING ="User.findByFirstNameContaining";
    public static final String FIND_BY_LASTNAME = "User.findByLastName";
    public static final String FIND_BY_LASTNAME_CONTAINING ="User.findByLastNameContaining";
    public static final String FIND_BY_EMAIL = "User.findByEmail";
    public static final String FIND_BY_EMAIL_CONTAINING ="User.findByEmailContaining";
    public static final String FIND_BY_STREET = "User.findByStreet";
    public static final String FIND_BY_STREET_CONTAINING ="User.findByStreetContaining";
    public static final String FIND_BY_POSTALCODE = "User.findByPostalCode";
    public static final String FIND_BY_POSTALCODE_CONTAINING ="User.findByPostalCodeContaining";
    public static final String FIND_BY_CITY = "User.findByCity";
    public static final String FIND_BY_CITY_CONTAINING ="User.findByCityContaining";
    public static final String FIND_BY_PASSWORD = "User.findByPassword";
    public static final String FIND_BY_PASSWORD_CONTAINING ="User.findByPasswordContaining";
    public static final String FIND_BY_INITIALUSERTYPE = "User.findByInitialUserType";
    public static final String FIND_BY_INITIALUSERTYPE_CONTAINING ="User.findByInitialUserTypeContaining";
    public static final String FIND_BY_REGISTRATIONLINK = "User.findByRegistrationLink";
    public static final String FIND_BY_REGISTRATIONLINK_CONTAINING ="User.findByRegistrationLinkContaining";
    public static final String FIND_BY_HOST = "User.findByHost";
    public static final String FIND_BY_HOST_CONTAINING ="User.findByHostContaining";
    public static final String FIND_BY_IP = "User.findByIp";
    public static final String FIND_BY_IP_CONTAINING ="User.findByIpContaining";
    public static final String FIND_BY_ACCEPTEDTACSCRIPTOR = "User.findByAcceptedTacScriptor";
    public static final String FIND_BY_ACCEPTEDTACCLIENT = "User.findByAcceptedTacClient";
    public static final String FIND_BY_ISACTIVE = "User.findByIsActive";
    public static final String FIND_BY_ISDELETED = "User.findByIsDeleted";
    public static final String FIND_BY_CREATEDAT = "User.findByCreatedAt";
	
    @Id @Column(name="user_id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

//MP-MANAGED-ADDED-AREA-BEGINNING @salutation-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @salutation-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-salutation@
    @Column(name="salutation"  , length=45 , nullable=true , unique=false)
    private String salutation; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @first_name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @first_name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-first_name@
    @Column(name="first_name"  , length=100 , nullable=true , unique=false)
    private String firstName; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @last_name-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @last_name-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-last_name@
    @Column(name="last_name"  , length=100 , nullable=true , unique=false)
    private String lastName; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @email-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @email-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-email@
    @Column(name="email"  , length=255 , nullable=true , unique=false)
    private String email; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @street-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @street-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-street@
    @Column(name="street"  , length=100 , nullable=true , unique=false)
    private String street; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @postal_code-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @postal_code-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-postal_code@
    @Column(name="postal_code"  , length=45 , nullable=true , unique=false)
    private String postalCode; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @city-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @city-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-city@
    @Column(name="city"  , length=100 , nullable=true , unique=false)
    private String city; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @password-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @password-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-password@
    @Column(name="password"  , length=255 , nullable=true , unique=false)
    private String password; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @initial_user_type-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @initial_user_type-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-initial_user_type@
    @Column(name="initial_user_type"  , length=45 , nullable=false , unique=false)
    private String initialUserType; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @registration_link-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @registration_link-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-registration_link@
    @Column(name="registration_link"  , length=36 , nullable=true , unique=false)
    private String registrationLink; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @host-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @host-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-host@
    @Column(name="host"  , length=255 , nullable=true , unique=false)
    private String host; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @ip-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @ip-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-ip@
    @Column(name="ip"  , length=39 , nullable=true , unique=false)
    private String ip; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @accepted_tac_scriptor-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @accepted_tac_scriptor-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-accepted_tac_scriptor@
    @Column(name="accepted_tac_scriptor"   , nullable=false , unique=false)
    private Boolean acceptedTacScriptor; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @accepted_tac_client-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @accepted_tac_client-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-accepted_tac_client@
    @Column(name="accepted_tac_client"   , nullable=false , unique=false)
    private Boolean acceptedTacClient; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @is_active-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @is_active-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-is_active@
    @Column(name="is_active"   , nullable=false , unique=false)
    private Boolean isActive; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @is_deleted-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @is_deleted-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-is_deleted@
    @Column(name="is_deleted"   , nullable=false , unique=false)
    private Boolean isDeleted; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @created_at-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @created_at-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-created_at@
    @Column(name="created_at"   , nullable=false , unique=false)
    private Timestamp createdAt; 
//MP-MANAGED-UPDATABLE-ENDING

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="app_language", referencedColumnName = "iso6392t" , nullable=false , unique=false , insertable=true, updatable=true) 
    private Language appLanguage;  

    @Column(name="app_language" , length=3 , nullable=false , unique=true, insertable=false, updatable=false)
    private String appLanguage_;

    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="isoalpha3", referencedColumnName = "isoalpha3" , nullable=true , unique=true  , insertable=true, updatable=true) 
    private Country isoalpha3;  

    @Column(name="isoalpha3" , length=3 , nullable=true , unique=true, insertable=false, updatable=false)
    private String isoalpha3_;

    @ManyToOne (fetch=FetchType.LAZY , optional=false)
    @JoinColumn(name="app_source_key", referencedColumnName = "app_id" , nullable=false , unique=true  , insertable=true, updatable=true) 
    private App appSourceKey;  

    @Column(name="app_source_key" , length=36 , nullable=false , unique=true, insertable=false, updatable=false)
    private String appSourceKey_;

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @languageSkillUserViaUserId-field-user@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.LanguageSkill.class, fetch=FetchType.LAZY, mappedBy="userId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <LanguageSkill> languageSkillUserViaUserId = new HashSet<LanguageSkill>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @mailAddressUserViaUserIdSender-field-user@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.MailAddress.class, fetch=FetchType.LAZY, mappedBy="userIdSender", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <MailAddress> mailAddressUserViaUserIdSender = new HashSet<MailAddress>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @mailAddressUserViaUserIdRecipient-field-user@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.MailAddress.class, fetch=FetchType.LAZY, mappedBy="userIdRecipient", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <MailAddress> mailAddressUserViaUserIdRecipient = new HashSet<MailAddress>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @revinfoUserViaUserId-field-user@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Revinfo.class, fetch=FetchType.LAZY, mappedBy="userId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Revinfo> revinfoUserViaUserId = new HashSet<Revinfo>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scriptUserViaClientId-field-user@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Script.class, fetch=FetchType.LAZY, mappedBy="clientId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Script> scriptUserViaClientId = new HashSet<Script>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scriptUserViaScriptorId-field-user@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.Script.class, fetch=FetchType.LAZY, mappedBy="scriptorId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <Script> scriptUserViaScriptorId = new HashSet<Script>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @translationSkillUserViaUserId-field-user@
    @OneToMany (targetEntity=defaultroot.defautmodel.domain.defautmodel.TranslationSkill.class, fetch=FetchType.LAZY, mappedBy="userId", cascade=CascadeType.REMOVE)//, cascade=CascadeType.ALL)
    private Set <TranslationSkill> translationSkillUserViaUserId = new HashSet<TranslationSkill>(); 

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @m2m-competenceViaUserCompetenceByCompetenceId-user@
    @ManyToMany
    @JoinTable(name="USER_COMPETENCE", 
        joinColumns=@JoinColumn(name="user_id"), 
        inverseJoinColumns=@JoinColumn(name="competence_id") 
    )
    private Set <Competence> competenceViaUserCompetenceByCompetenceId = new HashSet <Competence> ();

//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @m2m-roleViaUserRoleByRoleId-user@
    @ManyToMany
    @JoinTable(name="USER_ROLE", 
        joinColumns=@JoinColumn(name="user_id"), 
        inverseJoinColumns=@JoinColumn(name="role_id") 
    )
    private Set <Role> roleViaUserRoleByRoleId = new HashSet <Role> ();

//MP-MANAGED-UPDATABLE-ENDING
    /**
    * Default constructor
    */
    public User() {
    }

	/**
	* All field constructor 
	*/
    public User(
       Integer userId,
       String salutation,
       String firstName,
       String lastName,
       String email,
       String street,
       String postalCode,
       String city,
       String isoalpha3,
       String password,
       String initialUserType,
       String registrationLink,
       String appSourceKey,
       String appLanguage,
       String host,
       String ip,
       Boolean acceptedTacScriptor,
       Boolean acceptedTacClient,
       Boolean isActive,
       Boolean isDeleted,
       Timestamp createdAt) {
	 this(
       userId,
       salutation,
       firstName,
       lastName,
       email,
       street,
       postalCode,
       city,
       isoalpha3,
       password,
       initialUserType,
       registrationLink,
       appSourceKey,
       appLanguage,
       host,
       ip,
       acceptedTacScriptor,
       acceptedTacClient,
       isActive,
       isDeleted,
       createdAt
	 ,true);
	}
    
	public User(
       Integer userId,
       String salutation,
       String firstName,
       String lastName,
       String email,
       String street,
       String postalCode,
       String city,
       String isoalpha3,
       String password,
       String initialUserType,
       String registrationLink,
       String appSourceKey,
       String appLanguage,
       String host,
       String ip,
       Boolean acceptedTacScriptor,
       Boolean acceptedTacClient,
       Boolean isActive,
       Boolean isDeleted,
       Timestamp createdAt	
    , boolean setRelationship) {
       //primary keys
       setUserId (userId);
       //attributes
       setSalutation (salutation);
       setFirstName (firstName);
       setLastName (lastName);
       setEmail (email);
       setStreet (street);
       setPostalCode (postalCode);
       setCity (city);
       setPassword (password);
       setInitialUserType (initialUserType);
       setRegistrationLink (registrationLink);
       setHost (host);
       setIp (ip);
       setAcceptedTacScriptor (acceptedTacScriptor);
       setAcceptedTacClient (acceptedTacClient);
       setIsActive (isActive);
       setIsDeleted (isDeleted);
       setCreatedAt (createdAt);
       //parents
       if (setRelationship) this.appLanguage = new Language();
       if (setRelationship) this.appLanguage.setIso6392t(appLanguage); 
	   setAppLanguage_ (appLanguage);
       if (setRelationship) this.isoalpha3 = new Country();
       if (setRelationship) this.isoalpha3.setIsoalpha3(isoalpha3); 
	   setIsoalpha3_ (isoalpha3);
       if (setRelationship) this.appSourceKey = new App();
       if (setRelationship) this.appSourceKey.setAppId(appSourceKey); 
	   setAppSourceKey_ (appSourceKey);
    }

	public User flat() {
	   return new User(
          getUserId(),
          getSalutation(),
          getFirstName(),
          getLastName(),
          getEmail(),
          getStreet(),
          getPostalCode(),
          getCity(),
          getIsoalpha3_(),
          getPassword(),
          getInitialUserType(),
          getRegistrationLink(),
          getAppSourceKey_(),
          getAppLanguage_(),
          getHost(),
          getIp(),
          getAcceptedTacScriptor(),
          getAcceptedTacClient(),
          getIsActive(),
          getIsDeleted(),
          getCreatedAt()
       , false
	   );
	}

    public Integer getUserId() {
        return userId;
    }
	
    public void setUserId (Integer userId) {
        this.userId =  userId;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-salutation@
    public String getSalutation() {
        return salutation;
    }
	
    public void setSalutation (String salutation) {
        this.salutation =  salutation;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-first_name@
    public String getFirstName() {
        return firstName;
    }
	
    public void setFirstName (String firstName) {
        this.firstName =  firstName;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-last_name@
    public String getLastName() {
        return lastName;
    }
	
    public void setLastName (String lastName) {
        this.lastName =  lastName;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-email@
    public String getEmail() {
        return email;
    }
	
    public void setEmail (String email) {
        this.email =  email;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-street@
    public String getStreet() {
        return street;
    }
	
    public void setStreet (String street) {
        this.street =  street;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-postal_code@
    public String getPostalCode() {
        return postalCode;
    }
	
    public void setPostalCode (String postalCode) {
        this.postalCode =  postalCode;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-city@
    public String getCity() {
        return city;
    }
	
    public void setCity (String city) {
        this.city =  city;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-password@
    public String getPassword() {
        return password;
    }
	
    public void setPassword (String password) {
        this.password =  password;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-initial_user_type@
    public String getInitialUserType() {
        return initialUserType;
    }
	
    public void setInitialUserType (String initialUserType) {
        this.initialUserType =  initialUserType;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-registration_link@
    public String getRegistrationLink() {
        return registrationLink;
    }
	
    public void setRegistrationLink (String registrationLink) {
        this.registrationLink =  registrationLink;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-host@
    public String getHost() {
        return host;
    }
	
    public void setHost (String host) {
        this.host =  host;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-ip@
    public String getIp() {
        return ip;
    }
	
    public void setIp (String ip) {
        this.ip =  ip;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-accepted_tac_scriptor@
    public Boolean getAcceptedTacScriptor() {
        return acceptedTacScriptor;
    }
	
    public void setAcceptedTacScriptor (Boolean acceptedTacScriptor) {
        this.acceptedTacScriptor =  acceptedTacScriptor;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-accepted_tac_client@
    public Boolean getAcceptedTacClient() {
        return acceptedTacClient;
    }
	
    public void setAcceptedTacClient (Boolean acceptedTacClient) {
        this.acceptedTacClient =  acceptedTacClient;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-is_active@
    public Boolean getIsActive() {
        return isActive;
    }
	
    public void setIsActive (Boolean isActive) {
        this.isActive =  isActive;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-is_deleted@
    public Boolean getIsDeleted() {
        return isDeleted;
    }
	
    public void setIsDeleted (Boolean isDeleted) {
        this.isDeleted =  isDeleted;
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


    public Language getAppLanguage () {
    	return appLanguage;
    }
	
    public void setAppLanguage (Language appLanguage) {
    	this.appLanguage = appLanguage;
    }

    public String getAppLanguage_() {
        return appLanguage_;
    }
	
    public void setAppLanguage_ (String appLanguage) {
        this.appLanguage_ =  appLanguage;
    }
	
    public Country getIsoalpha3 () {
    	return isoalpha3;
    }
	
    public void setIsoalpha3 (Country isoalpha3) {
    	this.isoalpha3 = isoalpha3;
    }

    public String getIsoalpha3_() {
        return isoalpha3_;
    }
	
    public void setIsoalpha3_ (String isoalpha3) {
        this.isoalpha3_ =  isoalpha3;
    }
	
    public App getAppSourceKey () {
    	return appSourceKey;
    }
	
    public void setAppSourceKey (App appSourceKey) {
    	this.appSourceKey = appSourceKey;
    }

    public String getAppSourceKey_() {
        return appSourceKey_;
    }
	
    public void setAppSourceKey_ (String appSourceKey) {
        this.appSourceKey_ =  appSourceKey;
    }
	

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @languageSkillUserViaUserId-getter-user@
    public Set<LanguageSkill> getLanguageSkillUserViaUserId() {
        if (languageSkillUserViaUserId == null){
            languageSkillUserViaUserId = new HashSet<LanguageSkill>();
        }
        return languageSkillUserViaUserId;
    }

    public void setLanguageSkillUserViaUserId (Set<LanguageSkill> languageSkillUserViaUserId) {
        this.languageSkillUserViaUserId = languageSkillUserViaUserId;
    }	
    
    public void addLanguageSkillUserViaUserId (LanguageSkill element) {
    	    getLanguageSkillUserViaUserId().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @mailAddressUserViaUserIdSender-getter-user@
    public Set<MailAddress> getMailAddressUserViaUserIdSender() {
        if (mailAddressUserViaUserIdSender == null){
            mailAddressUserViaUserIdSender = new HashSet<MailAddress>();
        }
        return mailAddressUserViaUserIdSender;
    }

    public void setMailAddressUserViaUserIdSender (Set<MailAddress> mailAddressUserViaUserIdSender) {
        this.mailAddressUserViaUserIdSender = mailAddressUserViaUserIdSender;
    }	
    
    public void addMailAddressUserViaUserIdSender (MailAddress element) {
    	    getMailAddressUserViaUserIdSender().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @mailAddressUserViaUserIdRecipient-getter-user@
    public Set<MailAddress> getMailAddressUserViaUserIdRecipient() {
        if (mailAddressUserViaUserIdRecipient == null){
            mailAddressUserViaUserIdRecipient = new HashSet<MailAddress>();
        }
        return mailAddressUserViaUserIdRecipient;
    }

    public void setMailAddressUserViaUserIdRecipient (Set<MailAddress> mailAddressUserViaUserIdRecipient) {
        this.mailAddressUserViaUserIdRecipient = mailAddressUserViaUserIdRecipient;
    }	
    
    public void addMailAddressUserViaUserIdRecipient (MailAddress element) {
    	    getMailAddressUserViaUserIdRecipient().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @revinfoUserViaUserId-getter-user@
    public Set<Revinfo> getRevinfoUserViaUserId() {
        if (revinfoUserViaUserId == null){
            revinfoUserViaUserId = new HashSet<Revinfo>();
        }
        return revinfoUserViaUserId;
    }

    public void setRevinfoUserViaUserId (Set<Revinfo> revinfoUserViaUserId) {
        this.revinfoUserViaUserId = revinfoUserViaUserId;
    }	
    
    public void addRevinfoUserViaUserId (Revinfo element) {
    	    getRevinfoUserViaUserId().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scriptUserViaClientId-getter-user@
    public Set<Script> getScriptUserViaClientId() {
        if (scriptUserViaClientId == null){
            scriptUserViaClientId = new HashSet<Script>();
        }
        return scriptUserViaClientId;
    }

    public void setScriptUserViaClientId (Set<Script> scriptUserViaClientId) {
        this.scriptUserViaClientId = scriptUserViaClientId;
    }	
    
    public void addScriptUserViaClientId (Script element) {
    	    getScriptUserViaClientId().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @scriptUserViaScriptorId-getter-user@
    public Set<Script> getScriptUserViaScriptorId() {
        if (scriptUserViaScriptorId == null){
            scriptUserViaScriptorId = new HashSet<Script>();
        }
        return scriptUserViaScriptorId;
    }

    public void setScriptUserViaScriptorId (Set<Script> scriptUserViaScriptorId) {
        this.scriptUserViaScriptorId = scriptUserViaScriptorId;
    }	
    
    public void addScriptUserViaScriptorId (Script element) {
    	    getScriptUserViaScriptorId().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @translationSkillUserViaUserId-getter-user@
    public Set<TranslationSkill> getTranslationSkillUserViaUserId() {
        if (translationSkillUserViaUserId == null){
            translationSkillUserViaUserId = new HashSet<TranslationSkill>();
        }
        return translationSkillUserViaUserId;
    }

    public void setTranslationSkillUserViaUserId (Set<TranslationSkill> translationSkillUserViaUserId) {
        this.translationSkillUserViaUserId = translationSkillUserViaUserId;
    }	
    
    public void addTranslationSkillUserViaUserId (TranslationSkill element) {
    	    getTranslationSkillUserViaUserId().add(element);
    }
    
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @userCompetenceViaUserByUserId-getter-user@
//MP-MANAGED-UPDATABLE-ENDING
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @userRoleViaUserByUserId-getter-user@
//MP-MANAGED-UPDATABLE-ENDING

    public Set<Competence> getCompetenceViaUserCompetenceByCompetenceId() {
        if (competenceViaUserCompetenceByCompetenceId == null){
            competenceViaUserCompetenceByCompetenceId = new HashSet<Competence>();
        }
        return competenceViaUserCompetenceByCompetenceId;
    }

    public void setCompetenceViaUserCompetenceByCompetenceId (Set<Competence> competenceViaUserCompetenceByCompetenceId) {
        this.competenceViaUserCompetenceByCompetenceId = competenceViaUserCompetenceByCompetenceId;
    }
    	
    public void addCompetenceViaUserCompetenceByCompetenceId (Competence element) {
        getCompetenceViaUserCompetenceByCompetenceId().add(element);
    }
	
    public Set<Role> getRoleViaUserRoleByRoleId() {
        if (roleViaUserRoleByRoleId == null){
            roleViaUserRoleByRoleId = new HashSet<Role>();
        }
        return roleViaUserRoleByRoleId;
    }

    public void setRoleViaUserRoleByRoleId (Set<Role> roleViaUserRoleByRoleId) {
        this.roleViaUserRoleByRoleId = roleViaUserRoleByRoleId;
    }
    	
    public void addRoleViaUserRoleByRoleId (Role element) {
        getRoleViaUserRoleByRoleId().add(element);
    }
	
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-user@
    @javax.persistence.PrePersist
    public void prePersist_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-user@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
