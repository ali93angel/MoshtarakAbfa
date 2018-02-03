package com.sa_sh.sepehr.moshtarakapp.Utills;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.JsonSyntaxException;
import com.sa_sh.sepehr.moshtarakapp.R;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.annotation.Annotation;
import java.net.SocketTimeoutException;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by Leon on 12/9/2017.
 */

public class CustomErrorHandling extends Exception {
    static String errorMessage;
    private static Context context;
    private int ErrorCode;

    public CustomErrorHandling(Context context) {
        this.context = context;
    }

    public void Handle() {
        Errors errors;
        switch (ErrorCode) {
            case 100: {
                errors = Errors.Continue;
            }
            case 101: {
                errors = Errors.SwitchingProtocols;
            }
            case 102: {
                errors = Errors.Processing;
            }
            case 200: {
                errors = Errors.Ok;
            }
            case 201: {
                errors = Errors.Created;
            }
            case 202: {
                errors = Errors.Accepted;
            }
            case 203: {
                errors = Errors.NonAuthoritativeInformation;
            }
            case 204: {
                errors = Errors.NoContent;
            }
            case 205: {
                errors = Errors.ResetContent;
            }
            case 206: {
                errors = Errors.PartialContent;
            }
            case 207: {
                errors = Errors.MultiStatus;
            }
            case 208: {
                errors = Errors.AlreadyReported;
            }
            case 226: {
                errors = Errors.IMUsed;
            }
            case 300: {
                errors = Errors.MultipleChoice;
            }
            case 301: {
                errors = Errors.MovedPermanently;
            }
            case 302: {
                errors = Errors.Found;
            }
            case 303: {
                errors = Errors.SeeOther;
            }
            case 304: {
                errors = Errors.NotModified;
            }
            case 305: {
                errors = Errors.UseProxy;
            }
            case 306: {
                errors = Errors.Unused;
            }
            case 307: {
                errors = Errors.TemporaryRedirect;
            }
            case 308: {
                errors = Errors.PermanentRedirect;
            }
            case 400: {
                errors = Errors.BadRequest;
            }
            case 401: {
                errors = Errors.Unauthorized;
            }
            case 402: {
                errors = Errors.DailyLimitExceeded;
            }
            case 403: {
                errors = Errors.Forbidden;
            }
            case 404: {
                errors = Errors.NotFound;
            }
            case 405: {
                errors = Errors.MethodNotAllowed;
            }
            case 406: {
                errors = Errors.NotAcceptable;
            }
            case 407: {
                errors = Errors.ProxyAuthenticationRequired;
            }
            case 408: {
                errors = Errors.RequestTimeout;
            }
            case 409: {
                errors = Errors.AccountAlreadyExists;
            }
            case 410: {
                errors = Errors.Deleted;
            }
            case 411: {
                errors = Errors.MissingContentLengthHeader;
            }
            case 412: {
                errors = Errors.PreconditionFailed;
            }
            case 413: {
                errors = Errors.RequestBodyTooLarge;
            }
            case 414: {
                errors = Errors.UnsupportedMediaType;
            }
            case 415: {
                errors = Errors.UnsupportedMediaType;
            }
            case 416: {
                errors = Errors.RequestedRangeNotSatisfiable;
            }
            case 417: {
                errors = Errors.ExpectationFailed;
            }
            case 423: {
                errors = Errors.Locked;
            }
            case 424: {
                errors = Errors.FailedDependency;
            }
            case 428: {
                errors = Errors.PreconditionRequired;
            }
            case 429: {
                errors = Errors.TooManyRequest;
            }
            case 500: {
                errors = Errors.InternalServerError;
            }
            case 501: {
                errors = Errors.NotImplemented;
            }
            case 503: {
                errors = Errors.ServerBusy;
            }
            case 511: {
                errors = Errors.NetworkAuthenticationRequired;
            }
            case 598: {
                errors = Errors.NetworkReadTimeoutError;
            }
            case 599: {
                errors = Errors.NetworkConnectTimeoutError;
            }
            default:
                errors = Errors.TryAgain;
        }

        Toast.makeText(context, errors.toString(), Toast.LENGTH_LONG).show();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(10);
    }

    public static String getErrorMessage(Throwable throwable) {
        if (throwable instanceof IOException) {
            errorMessage = context.getString(R.string.error_IO);
            return errorMessage;
        } else if (throwable instanceof SocketTimeoutException) {
            errorMessage = context.getString(R.string.error_Socket);
        } else if (throwable instanceof InterruptedIOException) {
            errorMessage = context.getString(R.string.error_disconnected);
        } else {
            errorMessage = context.getString(R.string.error_other);
        }
        return errorMessage;
    }

    public static String getErrorMessage(int httpResponseCode) {
        String errorMessage = "";
        if (httpResponseCode == 500) {
            errorMessage = "خطای سرور";
        } else if (httpResponseCode == 400) {
            errorMessage = "در حال حاضر اطلاعات بارگیری جدیدی برای شما وجود ندارد";
        } else if (httpResponseCode == 404) {
            errorMessage = "خطای آدرس";
        } else if (httpResponseCode == 401) {
            errorMessage = "از ثبت شدن دستگاه در سامانه قرائت اطمینان حاصل کنید ";
        } else if (httpResponseCode == 405) {
            errorMessage = "همکار گرامی لطفا نسخه به روز شده اپلیکیشن را از منوی تنظیمات  بخش به روز رسانی دریافت نمایید";
        } else if (httpResponseCode == 406) {
            errorMessage = "همکار گرامی لطفا چهت دریافت آخرین نسخه اپلیکیشن با راهبر تماس حاصل فرمایید";
        }
        return errorMessage;
    }

    public static APIError parseError(Response<?> response) {
        try {
            Converter<ResponseBody, APIError> converter =
                    NetworkHelper.getInstance(false)
                            .responseBodyConverter(APIError.class, new Annotation[0]);
            APIError error;
            error = converter.convert(response.errorBody());
            return error;
        } catch (IOException e) {
            return new APIError();
        } catch (JsonSyntaxException e) {
            return new APIError();
        } catch (Exception e) {
            return new APIError();
        }
    }

    public static class APIError {

        private int Status;
        private String Message;

        public APIError() {
        }

        public int status() {
            return Status;
        }

        public String message() {
            return Message;
        }
    }
}