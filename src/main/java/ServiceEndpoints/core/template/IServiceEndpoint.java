package ServiceEndpoints.core.template;
import ServiceEndpoints.core.entity.Param;
import ServiceEndpoints.core.entity.RequestBody;

import java.util.List;


public interface IServiceEndpoint {

    String url();

    /**
     * Define HTTP method type
     * @return POST/GET/PUT/DELETE/PATCH
     */
    HttpMethod httpMethod();


    /**
     * Define service endpoint user type
     * @return FREE_USER/MERCHANT/DRIVER/INETERNAL
     */
    UserType userType();

    /**
     * Define service endpoint query params
     * @return List of type params
     */
    List<Param> queryParameters();

    /**
     * Define service endpoint path params
     * @return List of type params
     */
    List<Param> pathParameters();

    /**
     * Define service endpoint headers
     * @return List of type params
     */
    List<Param> headers();

    /**
     * Define service endpoint body
     *@return  an intance of type RequestBody
     */
    RequestBody body();

}
