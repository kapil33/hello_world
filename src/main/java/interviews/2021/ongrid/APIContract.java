package interviews.ongrid;

public class APIContract {
    /*API Contract for consumer producer network
     * API contract should allow for:
     * 1. signup for consumer and producer
     * 2. login for consumer and producer
     * 3. producer can add 4 types of products in the inventory and decide their price
     * 4. consumer can pay through their wallet for any product and buy it
     * */

    //API responses are missing
    //response body:
    //{"code", "message", "data"}

    /*
     * 1. for consumer:
     *       url = "/signup/consumer" {url = "/consumer/signup"}
     *       request_header = {username, password}
     *       request_body = {member_type, gender, address, phone_number}
     *       responses
     *               = 200, ok
     *                  {code:1000, message:"SUCCESS", data:{}}
     *               = 400, bad_request
     *                  {code:4001, message:"phone number already associated with consumer account", data:{}}
     *                  {code:4002, message:"essential params are missing", data:{}}
     *   for producer:
     *       url = "/signup/producer"
     *       request_header = {username, password}
     *       request_body = {member_type, gender, address, phone_number}
     *
     * 2. for consumer:
     *       url = "/login/consumer"
     *       request_header = {username, password}
     *       request_body = {}
     *   for producer:
     *       url = "/login/producer"
     *       request_header = {username, password}
     *       request_body = {}
     *
     * 3. url = "/add/products/inventory"
     *    request_header = {auth_token}
     *    request_body = {category, {item_name, qty, price, description}}
     *
     * 4. url = "/checkout/payment"
     *    request_header = {auth_token}
     *    request_body = {item_name, qty, price, payment_method}
     *
     * */
}
