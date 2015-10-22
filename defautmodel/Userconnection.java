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
import defaultroot.defautmodel.domain.defautmodel.UserconnectionId;

/**
 *
 * <p>Title: Userconnection</p>
 *
 * <p>Description: Domain Object describing a Userconnection entity</p>
 *
 */
@Entity (name="Userconnection")
@Table (name="\"UserConnection\"")
@NamedQueries ({
	 @NamedQuery(name="Userconnection.findAll", query="SELECT userconnection FROM Userconnection userconnection")
	,@NamedQuery(name="Userconnection.findByRank", query="SELECT userconnection FROM Userconnection userconnection WHERE userconnection.rank = :rank")

	,@NamedQuery(name="Userconnection.findByDisplayname", query="SELECT userconnection FROM Userconnection userconnection WHERE userconnection.displayname = :displayname")
	,@NamedQuery(name="Userconnection.findByDisplaynameContaining", query="SELECT userconnection FROM Userconnection userconnection WHERE userconnection.displayname like :displayname")

	,@NamedQuery(name="Userconnection.findByProfileurl", query="SELECT userconnection FROM Userconnection userconnection WHERE userconnection.profileurl = :profileurl")
	,@NamedQuery(name="Userconnection.findByProfileurlContaining", query="SELECT userconnection FROM Userconnection userconnection WHERE userconnection.profileurl like :profileurl")

	,@NamedQuery(name="Userconnection.findByImageurl", query="SELECT userconnection FROM Userconnection userconnection WHERE userconnection.imageurl = :imageurl")
	,@NamedQuery(name="Userconnection.findByImageurlContaining", query="SELECT userconnection FROM Userconnection userconnection WHERE userconnection.imageurl like :imageurl")

	,@NamedQuery(name="Userconnection.findByAccesstoken", query="SELECT userconnection FROM Userconnection userconnection WHERE userconnection.accesstoken = :accesstoken")
	,@NamedQuery(name="Userconnection.findByAccesstokenContaining", query="SELECT userconnection FROM Userconnection userconnection WHERE userconnection.accesstoken like :accesstoken")

	,@NamedQuery(name="Userconnection.findBySecret", query="SELECT userconnection FROM Userconnection userconnection WHERE userconnection.secret = :secret")
	,@NamedQuery(name="Userconnection.findBySecretContaining", query="SELECT userconnection FROM Userconnection userconnection WHERE userconnection.secret like :secret")

	,@NamedQuery(name="Userconnection.findByRefreshtoken", query="SELECT userconnection FROM Userconnection userconnection WHERE userconnection.refreshtoken = :refreshtoken")
	,@NamedQuery(name="Userconnection.findByRefreshtokenContaining", query="SELECT userconnection FROM Userconnection userconnection WHERE userconnection.refreshtoken like :refreshtoken")

	,@NamedQuery(name="Userconnection.findByExpiretime", query="SELECT userconnection FROM Userconnection userconnection WHERE userconnection.expiretime = :expiretime")

})

public class Userconnection implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Userconnection.findAll";
    public static final String FIND_BY_RANK = "Userconnection.findByRank";
    public static final String FIND_BY_DISPLAYNAME = "Userconnection.findByDisplayname";
    public static final String FIND_BY_DISPLAYNAME_CONTAINING ="Userconnection.findByDisplaynameContaining";
    public static final String FIND_BY_PROFILEURL = "Userconnection.findByProfileurl";
    public static final String FIND_BY_PROFILEURL_CONTAINING ="Userconnection.findByProfileurlContaining";
    public static final String FIND_BY_IMAGEURL = "Userconnection.findByImageurl";
    public static final String FIND_BY_IMAGEURL_CONTAINING ="Userconnection.findByImageurlContaining";
    public static final String FIND_BY_ACCESSTOKEN = "Userconnection.findByAccesstoken";
    public static final String FIND_BY_ACCESSTOKEN_CONTAINING ="Userconnection.findByAccesstokenContaining";
    public static final String FIND_BY_SECRET = "Userconnection.findBySecret";
    public static final String FIND_BY_SECRET_CONTAINING ="Userconnection.findBySecretContaining";
    public static final String FIND_BY_REFRESHTOKEN = "Userconnection.findByRefreshtoken";
    public static final String FIND_BY_REFRESHTOKEN_CONTAINING ="Userconnection.findByRefreshtokenContaining";
    public static final String FIND_BY_EXPIRETIME = "Userconnection.findByExpiretime";
	
    @EmbeddedId
    private UserconnectionId userconnectionId__;
    @Column(name="userId" , length=255 , nullable=false , unique=false , insertable=false, updatable=false)
    private String userid_;
    @Column(name="providerId" , length=255 , nullable=false , unique=false , insertable=false, updatable=false)
    private String providerid_;
    @Column(name="providerUserId" , length=255 , nullable=false , unique=false , insertable=false, updatable=false)
    private String provideruserid_;
//MP-MANAGED-ADDED-AREA-BEGINNING @rank-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @rank-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-rank@
    @Column(name="rank"   , nullable=false , unique=false)
    private Integer rank; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @displayName-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @displayName-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-displayName@
    @Column(name="displayName"  , length=255 , nullable=true , unique=false)
    private String displayname; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @profileUrl-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @profileUrl-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-profileUrl@
    @Column(name="profileUrl"  , length=512 , nullable=true , unique=false)
    private String profileurl; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @imageUrl-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @imageUrl-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-imageUrl@
    @Column(name="imageUrl"  , length=512 , nullable=true , unique=false)
    private String imageurl; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @accessToken-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @accessToken-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-accessToken@
    @Column(name="accessToken"  , length=512 , nullable=false , unique=false)
    private String accesstoken; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @secret-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @secret-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-secret@
    @Column(name="secret"  , length=512 , nullable=true , unique=false)
    private String secret; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @refreshToken-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @refreshToken-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-refreshToken@
    @Column(name="refreshToken"  , length=512 , nullable=true , unique=false)
    private String refreshtoken; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @expireTime-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @expireTime-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-expireTime@
    @Column(name="expireTime"   , nullable=true , unique=false)
    private Long expiretime; 
//MP-MANAGED-UPDATABLE-ENDING

    /**
    * Default constructor
    */
    public Userconnection() {
    }

	/**
	* All field constructor 
	*/
    public Userconnection(
       String userid,
       String providerid,
       String provideruserid,
       Integer rank,
       String displayname,
       String profileurl,
       String imageurl,
       String accesstoken,
       String secret,
       String refreshtoken,
       Long expiretime) {
	 this(
       userid,
       providerid,
       provideruserid,
       rank,
       displayname,
       profileurl,
       imageurl,
       accesstoken,
       secret,
       refreshtoken,
       expiretime
	 ,true);
	}
    
	public Userconnection(
       String userid,
       String providerid,
       String provideruserid,
       Integer rank,
       String displayname,
       String profileurl,
       String imageurl,
       String accesstoken,
       String secret,
       String refreshtoken,
       Long expiretime	
    , boolean setRelationship) {
       //primary keys
       this.userconnectionId__ = new UserconnectionId();  	
       this.userconnectionId__.setUserid (userid);
       this.userconnectionId__.setProviderid (providerid);
       this.userconnectionId__.setProvideruserid (provideruserid);
       //attributes
       setRank (rank);
       setDisplayname (displayname);
       setProfileurl (profileurl);
       setImageurl (imageurl);
       setAccesstoken (accesstoken);
       setSecret (secret);
       setRefreshtoken (refreshtoken);
       setExpiretime (expiretime);
       //parents
    }

	public Userconnection flat() {
	   return new Userconnection(
		  getUserconnectionId__().getUserid(),
		  getUserconnectionId__().getProviderid(),
		  getUserconnectionId__().getProvideruserid(),
          getRank(),
          getDisplayname(),
          getProfileurl(),
          getImageurl(),
          getAccesstoken(),
          getSecret(),
          getRefreshtoken(),
          getExpiretime()
       , false
	   );
	}


    public UserconnectionId getUserconnectionId__() {
		if (userconnectionId__==null) userconnectionId__ = new UserconnectionId();
        return userconnectionId__;
    }
	
    public void setUserconnectionId__ (UserconnectionId userconnectionId__) {
        this.userconnectionId__ =  userconnectionId__;
    }
    public String getUserid_() {
        return userid_;
    }
	
    public void setUserid_ (String userid) {
        this.userid_ =  userid_;
    }
    
    public String getProviderid_() {
        return providerid_;
    }
	
    public void setProviderid_ (String providerid) {
        this.providerid_ =  providerid_;
    }
    
    public String getProvideruserid_() {
        return provideruserid_;
    }
	
    public void setProvideruserid_ (String provideruserid) {
        this.provideruserid_ =  provideruserid_;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-rank@
    public Integer getRank() {
        return rank;
    }
	
    public void setRank (Integer rank) {
        this.rank =  rank;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-displayName@
    public String getDisplayname() {
        return displayname;
    }
	
    public void setDisplayname (String displayname) {
        this.displayname =  displayname;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-profileUrl@
    public String getProfileurl() {
        return profileurl;
    }
	
    public void setProfileurl (String profileurl) {
        this.profileurl =  profileurl;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-imageUrl@
    public String getImageurl() {
        return imageurl;
    }
	
    public void setImageurl (String imageurl) {
        this.imageurl =  imageurl;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-accessToken@
    public String getAccesstoken() {
        return accesstoken;
    }
	
    public void setAccesstoken (String accesstoken) {
        this.accesstoken =  accesstoken;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-secret@
    public String getSecret() {
        return secret;
    }
	
    public void setSecret (String secret) {
        this.secret =  secret;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-refreshToken@
    public String getRefreshtoken() {
        return refreshtoken;
    }
	
    public void setRefreshtoken (String refreshtoken) {
        this.refreshtoken =  refreshtoken;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-expireTime@
    public Long getExpiretime() {
        return expiretime;
    }
	
    public void setExpiretime (Long expiretime) {
        this.expiretime =  expiretime;
    }
	
//MP-MANAGED-UPDATABLE-ENDING




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-UserConnection@
    @javax.persistence.PrePersist
    public void prePersist_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-UserConnection@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}
