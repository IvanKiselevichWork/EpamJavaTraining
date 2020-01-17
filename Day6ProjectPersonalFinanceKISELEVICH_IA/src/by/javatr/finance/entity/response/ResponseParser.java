package by.javatr.finance.entity.response;

public class ResponseParser {

    private final static char DELIMITER = ';';
    private final static char SMALL_DELIMITER = ',';

    public ResponseParser() {

    }

    public Response parseResponse(String responseStr) {
        String command = null;
        int lastIndex = 0;
        int newIndex = responseStr.indexOf(DELIMITER);

        command = responseStr.substring(lastIndex, newIndex);
        Response response = new Response();
        response.setCommand(command);
        lastIndex = newIndex;

        newIndex = responseStr.indexOf(DELIMITER, lastIndex);
        String data = responseStr.substring(lastIndex, newIndex);
        response.setData(data);
        lastIndex = newIndex;

        newIndex = responseStr.indexOf(DELIMITER, lastIndex);
        String listStr = responseStr.substring(lastIndex, newIndex);
        String[] list = listStr.split(String.valueOf(SMALL_DELIMITER), -1);
        lastIndex = newIndex;

        if (command.equals("MENU")) {
            response.setMenuOptions(list);

            newIndex = responseStr.indexOf(DELIMITER, lastIndex);
            listStr = responseStr.substring(lastIndex, newIndex);
            list = listStr.split(String.valueOf(SMALL_DELIMITER), -1);
            lastIndex = newIndex;

            response.setRequestsOptions(list);
        } else if (command.equals("INPUT")) {
            response.setParameters(list);
        }

        newIndex = responseStr.indexOf(DELIMITER, lastIndex);
        String nextRequest = responseStr.substring(lastIndex, newIndex);
        response.setNextRequest(nextRequest);
        return response;
    }

    public String createResponseString(Response response) {
        StringBuffer responseBuilder = new StringBuffer();

        responseBuilder.append(response.getCommand());
        responseBuilder.append(DELIMITER);

        responseBuilder.append(response.getData());
        responseBuilder.append(DELIMITER);

        if (response.getCommand().equals("MENU")) {
            for (String option : response.getMenuOptions()) {
                responseBuilder.append(option);
                responseBuilder.append(SMALL_DELIMITER);
            }
            responseBuilder.append(DELIMITER);
            for (String option : response.getRequestsOptions()) {
                responseBuilder.append(option);
                responseBuilder.append(SMALL_DELIMITER);
            }
            responseBuilder.append(DELIMITER);
        } else if (response.getCommand().equals("INPUT")) {
            for (String parameter : response.getParameters()) {
                responseBuilder.append(parameter);
                responseBuilder.append(SMALL_DELIMITER);
            }
            responseBuilder.append(DELIMITER);
        }

        responseBuilder.append(response.getNextRequest());
        responseBuilder.append(DELIMITER);

        return responseBuilder.toString();
    }
}
