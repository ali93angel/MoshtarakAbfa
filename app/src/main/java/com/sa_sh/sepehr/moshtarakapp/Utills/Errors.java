package com.sa_sh.sepehr.moshtarakapp.Utills;

/**
 * Created by Leon on 12/9/2017.
 */

public enum Errors {
    Continue(100, "The client should continue with its request."),
    SwitchingProtocols(101, "The server understands and is willing to comply with the client's request, via the Upgrade message header field (section 14.42), for a change in the application protocol being used on this connection."),
    Processing(102, "The 102 (Processing) status code is an interim response used to inform the client that the server has accepted the complete request, but has not yet completed it."),
    Ok(200, "Request Successfully be response."),
    Created(201, "The request has been fulfilled and resulted in a new resource being created."),
    Accepted(202, "The request has been accepted for processing, but the processing has not been completed. "),
    NonAuthoritativeInformation(203, "The returned metainformation in the entity-header is not the definitive set as available from the origin server, but is gathered from a local or a third-party copy."),
    NoContent(204, "The server successfully processed the request, but is not returning any content."),
    ResetContent(205, "The server has fulfilled the request and the user agent SHOULD reset the document view which caused the request to be sent."),
    PartialContent(206, "The server has fulfilled the partial GET request for the resource."),
    MultiStatus(207, "The server has fulfilled the request and the user agent SHOULD reset the document view which caused the request to be sent."),
    AlreadyReported(208, "The members of a DAV binding have already been enumerated in a previous reply to this request, and are not being included again."),
    IMUsed(226, "The server has fulfilled the request and the user agent SHOULD reset the document view which caused the request to be sent."),
    MultipleChoice(300, "The requested resource corresponds to any one of a set of representations."),
    MovedPermanently(301, "This request and future requests for the same operation have to be sent to the URL specified in the Location header of this response instead of to the URL to which this request was sent."),
    Found(302, "The requested resource resides temporarily under a different URI."),
    SeeOther(303, "Your request was processed successfully. To obtain your response, send a GET request to the URL specified in the Location header."),
    NotModified(304, "The condition specified in the conditional header(s) was not met for a read operation."),
    UseProxy(305, "The requested resource MUST be accessed through the proxy given by the Location field."),
    Unused(306, "The 306 status code was used in a previous version of the specification, is no longer used, and the code is reserved."),
    TemporaryRedirect(307, "To have your request processed, resend it to the URL specified in the Location header of this response."),
    PermanentRedirect(308, "The request, and all future requests should be repeated using another URI."),
    BadRequest(400, "One of the query parameters specified in the request URI is not supported."),
    Unauthorized(401, "The user is not authorized to make the request."),
    DailyLimitExceeded(402, "The requested operation requires some kind of payment from the authenticated user."),
    Forbidden(403, "The account being accessed does not have sufficient permissions to execute this operation."),
    NotFound(404, "The specified resource does not exist."),
    MethodNotAllowed(405, "TThe resource doesn't support the specified HTTP verb."),
    NotAcceptable(406, "The resource identified by the request is only capable of generating response entities which have content characteristics not acceptable according to the accept headers sent in the request."),
    ProxyAuthenticationRequired(407, "This code is similar to 401 (Unauthorized), but indicates that the client must first authenticate itself with the proxy."),
    RequestTimeout(408, "The client did not produce a request within the time that the server was prepared to wait."),
    AccountAlreadyExists(409, "The requested operation failed because it tried to create a resource that already exists."),
    Deleted(410, "The request failed because the resource associated with the request has been deleted."),
    MissingContentLengthHeader(411, "The Content-Length header was not specified."),
    PreconditionFailed(412, "The condition specified in the conditional header(s) was not met for a write operation."),
    RequestBodyTooLarge(413, "The size of the request body exceeds the maximum size permitted."),
    UnsupportedMediaType(415, "The server is refusing to service the request because the entity of the request is in a format not supported by the requested resource for the requested method."),
    RequestedRangeNotSatisfiable(416, "The request specified a range that cannot be satisfied."),
    ExpectationFailed(417, "A client expectation cannot be met by the server."),
    Locked(423, "The 423 (Locked) status code means the source or destination resource of a method is locked."),
    FailedDependency(424, "The 424 (Failed Dependency) status code means that the method could not be performed on the resource because the requested action depended on another action and that action failed."),
    PreconditionRequired(428, "The request requires a precondition that is not provided."),
    TooManyRequest(429, "Too many requests have been sent within a given time span."),
    InternalServerError(500, "The server encountered an internal error. Please retry the request."),
    NotImplemented(501, "The requested operation has not been implemented."),
    ServerBusy(503, "The server is currently unable to receive requests. Please retry your request."),
    NetworkAuthenticationRequired(511, "The client needs to authenticate to gain network access"),
    NetworkReadTimeoutError(598, "This status code is not specified in any RFCs, but is used by some HTTP proxies to signal a network read timeout behind the proxy to a client in front of the proxy."),
    NetworkConnectTimeoutError(599, "This status code is not specified in any RFCs, but is used by some HTTP proxies to signal a network connect timeout behind the proxy to a client in front of the proxy."),
    TryAgain(0, "Please try again.");

    private final int errorCode;
    private final String description;

    private Errors(int errorCode, String description) {
        this.errorCode = errorCode;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return errorCode + ": " + description;
    }
}
