package ru.bgcrm.plugin.bgbilling.proto.model.inet;

import java.util.HashSet;
import java.util.Set;

import ru.bgcrm.model.IdTitle;

public class InetServiceType
	extends IdTitle
{
	public static final int SESSION_INITIATION_CALL = 0;
	public static final int SESSION_INITIATION_AUTO = 1;

	public static final int ADDRESS_TYPE_NONE = 0;
	
	/**
	 * Указанный диапазон
	 */
	public static final int ADDRESS_TYPE_RANGE = 1;
	
	/**
	 * Указанная сеть
	 */
	public static final int ADDRESS_TYPE_NET = 2;
	
	/**
	 * Указанный адрес
	 */
	public static final int ADDRESS_TYPE_SINGLE = 3;

	/**
	 * Динамический адрес
	 */
	public static final int ADDRESS_TYPE_DYNAMIC = 4;
	
	/**
	 * Динамический или указанный адрес
	 */
	public static final int ADDRESS_TYPE_DYNAMIC_OR_SINGLE = 5;
	
	/**
	 * Динамический или из диапазона
	 */
	public static final int ADDRESS_TYPE_DYNAMIC_OR_RANGE = 6;
	
	/**
	 * Либо выдавать указанный адрес, либо ничего не выдавать
	 */
	public static final int ADDRESS_TYPE_NONE_OR_SINGLE = 7;
	
	private Set<Integer> deviceTypeIds = new HashSet<Integer>();
	private Set<Integer> deviceGroupIds = new HashSet<Integer>();

	private int trafficTypeLinkId;

	private int sessionInitiationType;
	
	private int addressType;
	private boolean addressAllInterface;
	
	// количество макисмальных сессий, устанавливаемое по-умолчанию в сервисе
	private int sessionCountLimit;
	
	private boolean sessionCountLimitLock;

	// необходимо указать логин и пароль
	private boolean needLogin;
	// необходимо указать устройство
	private boolean needDevice;
	// необходимо указать интерфейс устройства
	private boolean needInterface;
	// интефрейс выделен для сервиса
	private boolean personalInterface = true;
	// необходимо указать Vlan
	private boolean needVlan;	
	// vlan выделен для сервиса 
	private boolean personalVlan = true;
	
	private boolean needIdentifier;
	
	/**
	 * Нужен ли MAC-адрес, нужно ли его отображать при редактировании сервиса
	 */
	private boolean needMacAddress;
	
	private boolean needContractObject;
	
	private boolean needRestriction;
	
	private Set<Integer> parentTypeIds = new HashSet<Integer>();
	
	private boolean ipFromParentRange;

	//конфигурация
	private String config;

	public Set<Integer> getDeviceTypeIds()
	{
		return deviceTypeIds;
	}

	public void setDeviceTypeIds( Set<Integer> deviceTypeIds )
	{
		this.deviceTypeIds = deviceTypeIds;
	}

	public Set<Integer> getDeviceGroupIds()
	{
		return deviceGroupIds;
	}

	public void setDeviceGroupIds( Set<Integer> deviceGroupIds )
	{
		this.deviceGroupIds = deviceGroupIds;
	}

	public int getTrafficTypeLinkId()
	{
		return trafficTypeLinkId;
	}

	public void setTrafficTypeLinkId( int trafficTypeLinkId )
	{
		this.trafficTypeLinkId = trafficTypeLinkId;
	}

	public int getSessionInitiationType()
	{
		return sessionInitiationType;
	}

	public void setSessionInitiationType( int sessionInitiationType )
	{
		this.sessionInitiationType = sessionInitiationType;
	}

	public int getAddressType()
	{
		return addressType;
	}

	public void setAddressType( int addressType )
	{
		this.addressType = addressType;
	}

	public boolean isAddressAllInterface()
	{
		return addressAllInterface;
	}

	public void setAddressAllInterface( boolean addressAllInterface )
	{
		this.addressAllInterface = addressAllInterface;
	}

	public int getSessionCountLimit()
	{
		return sessionCountLimit;
	}

	public void setSessionCountLimit( int sessionCountLimit )
	{
		this.sessionCountLimit = sessionCountLimit;
	}

	public boolean isSessionCountLimitLock()
	{
		return sessionCountLimitLock;
	}

	public void setSessionCountLimitLock( boolean sessionCountLimitLock )
	{
		this.sessionCountLimitLock = sessionCountLimitLock;
	}

	public boolean isNeedLogin()
	{
		return needLogin;
	}

	public void setNeedLogin( boolean needLogin )
	{
		this.needLogin = needLogin;
	}

	public boolean isNeedDevice()
	{
		return needDevice;
	}

	public void setNeedDevice( boolean needDevice )
	{
		this.needDevice = needDevice;
	}

	public boolean isNeedInterface()
	{
		return needInterface;
	}

	public void setNeedInterface( boolean needInterface )
	{
		this.needInterface = needInterface;
	}

	public boolean isPersonalInterface()
	{
		return personalInterface;
	}

	public void setPersonalInterface( boolean personalInterface )
	{
		this.personalInterface = personalInterface;
	}

	public boolean isNeedVlan()
	{
		return needVlan;
	}

	public void setNeedVlan( boolean needVlan )
	{
		this.needVlan = needVlan;
	}

	public boolean isPersonalVlan()
	{
		return personalVlan;
	}

	public void setPersonalVlan( boolean personalVlan )
	{
		this.personalVlan = personalVlan;
	}

	public boolean isNeedIdentifier()
	{
		return needIdentifier;
	}

	public void setNeedIdentifier( boolean needIdentifier )
	{
		this.needIdentifier = needIdentifier;
	}

	public boolean isNeedMacAddress()
	{
		return needMacAddress;
	}

	public void setNeedMacAddress( boolean needMacAddress )
	{
		this.needMacAddress = needMacAddress;
	}

	public boolean isNeedContractObject()
	{
		return needContractObject;
	}

	public void setNeedContractObject( boolean needContractObject )
	{
		this.needContractObject = needContractObject;
	}

	public boolean isNeedRestriction()
	{
		return needRestriction;
	}

	public void setNeedRestriction( boolean needRestriction )
	{
		this.needRestriction = needRestriction;
	}

	public Set<Integer> getParentTypeIds()
	{
		return parentTypeIds;
	}

	public void setParentTypeIds( Set<Integer> parentTypeIds )
	{
		this.parentTypeIds = parentTypeIds;
	}

	public boolean isIpFromParentRange()
	{
		return ipFromParentRange;
	}

	public void setIpFromParentRange( boolean ipFromParentRange )
	{
		this.ipFromParentRange = ipFromParentRange;
	}

	public String getConfig()
	{
		return config;
	}

	public void setConfig( String config )
	{
		this.config = config;
	}
}