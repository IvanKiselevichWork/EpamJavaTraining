package by.javatr.finance.entity.response;

public class Response {
    private String command;
    private String[] menuOptions;
    private String[] requestsOptions;
    private String[] parameters;
    private String data;
    private String nextRequest;

    public Response() {

    }

    public Response(String command, String[] menuOptions, String[] requestsOptions, String[] parameters, String data, String nextRequest) {
        this.command = command;
        this.menuOptions = menuOptions;
        this.requestsOptions = requestsOptions;
        this.parameters = parameters;
        this.data = data;
        this.nextRequest = nextRequest;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String[] getMenuOptions() {
        return menuOptions;
    }

    public void setMenuOptions(String[] menuOptions) {
        this.menuOptions = menuOptions;
    }

    public String[] getRequestsOptions() {
        return requestsOptions;
    }

    public void setRequestsOptions(String[] requestsOptions) {
        this.requestsOptions = requestsOptions;
    }

    public String[] getParameters() {
        return parameters;
    }

    public void setParameters(String[] parameters) {
        this.parameters = parameters;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNextRequest() {
        return nextRequest;
    }

    public void setNextRequest(String nextRequest) {
        this.nextRequest = nextRequest;
    }
}
