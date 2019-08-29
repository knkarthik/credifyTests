# Instructions to define endpoint class via implementing IServiceEndpoint

**`serviceEndpoint` :** Common package to define contracts of public/internal endpoints.

**[IServiceEndpoint](core/template/IServiceEndpoint.java) :** Interface to help define contract of an endpoint both public/internal. 


### Adding package
* `Endpoint` classes should be defined in their respective team/product package
* If the `Endpoint` class has dependencies on other `RequestBody` or `Response`  classes, then group these entity-classes within common 
package and name the package respective to the endpoint

### Naming the Class
* The endpoint-class' name should contain suffix `Endpoint`

### Using IServiceEndpoint
* All `Endpoint` classes should implement the interface `IServiceEndpoint` for both public/internal endpoints

### Adding local variables

* The local variables should be a list exact fields rather than undesired parent object (refer example below)

**Example :**
```
public class GetCustomerInfoEndpoint implements IServiceEndpoint {  
    private Customer customer;   //Avoid this unless customer-Object is required as a whole
    
public class GetCustomerInfoEndpoint implements IServiceEndpoint { 
    private String phone;       //Correct way, declare only the required fields of customer-object                                                
    private String email;
    
                                   
```
### Defining Constructor
* Constructor with appropriate fields should be defined for all methods except `GET`



### Defining URL and Parameter
* The URL definition is as per REST-Assured convention. That is if the  URL contains path-params/query-params, then the url string **should-not** include the params via format specifiers ,
rather the params should be defined in an `ArrayList` of `Param` type separately in the `pathParameter()` or `queryParameters()` respectively 
* For URL with query-params, there is no need of any String-appending to be defined, let the `url()` method just return the _**base-url**_ 


**Example for URL with path-param/s :**
```
@Override
public String url() { //Correct way to define URL with path param - restassured convention
    return MyProperties.findBookingIDHostUrl+ "{bookingID}";
}

@Override
public List<Param> pathParameters() {
    List<Param> pathParams = new ArrayList<>();
    pathParams.add(new Param("bookingID", bookingId));
    return pathParams;
}

```
**Example for URL with query-param/s :**
```
@Override                                   
public String url() {                       
    return MyProperties.searchPhoneNumberUrl; 
}

@Override                                             
public List<Param> queryParameters() {                
    ArrayList<Param> queryParams = new ArrayList<>(); 
    queryParams.add(new Param("phone_number",phone ));
    return queryParams;                               
}                                                                                                
```

### Defining HTTP method type
* The method type of the endpoint is defined in the `httpMethod()` class-method with help of `HttpMethod` enum

### Defining the user-type
* Here, the user-type points to the targeted user of the endpoint, for eg: customer, merchant or internal services etc.
* The user-type of the endpoint is defined in the `userType()` class-method with help of `UserType` enum

### Adding headers
* Do not skip adding the `Content-Type` in the headers `ArrayList`
* Avoid using object's field rather use local-fields directly (refer example below)

**Example :**
```
@Override
public List<Param> headers() {
    ...
    //Correct way to assigning header value with local field
    headers.add(new Param("myheader", "MyHeaderValue"));
    ... 
    return headers;
}
```   

### Defining body
* Specify the `java.lang.Class` info via `PojoClassName.class` rather than `pojoClassObject.getClass()` (refer example below)

**Example :** 
```
@Override                                                                               
public RequestBody body() {  // correct way                                                           
    return new RequestBody(MyRequestBody.class, myRequestBody);  
}

@Override                                                                               
public RequestBody body() {  // avoid this                                                           
    return new RequestBody(myRequestBody.getClass(),myRequestBody);  
}

                                                                                       
```
