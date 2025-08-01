

# ASNDetails


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**asNumber** | **String** |  |  [optional] |
|**organization** | **String** |  |  [optional] |
|**country** | **String** |  |  [optional] |
|**asnName** | **String** |  |  [optional] |
|**type** | **String** |  |  [optional] |
|**domain** | **URI** |  |  [optional] |
|**dateAllocated** | **LocalDate** |  |  [optional] |
|**allocationStatus** | **String** |  |  [optional] |
|**numOfIpv4Routes** | **Integer** |  |  [optional] |
|**numOfIpv6Routes** | **Integer** |  |  [optional] |
|**rir** | **String** |  |  [optional] |
|**routes** | **List&lt;String&gt;** | It will only be included in the response, if you set include&#x3D;routes in the request |  [optional] |
|**upstreams** | [**List&lt;ASNConnection&gt;**](ASNConnection.md) | It will only be included in the response, if you set include&#x3D;upstreams in the request |  [optional] |
|**downstreams** | [**List&lt;ASNConnection&gt;**](ASNConnection.md) | It will only be included in the response, if you set include&#x3D;downstreams in the request |  [optional] |
|**peers** | [**List&lt;ASNConnection&gt;**](ASNConnection.md) | It will only be included in the response, if you set include&#x3D;peers in the request |  [optional] |
|**whoisResponse** | **String** | It will only be included in the response, if you set include&#x3D;whois_response in the request |  [optional] |



