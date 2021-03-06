/**
 * @author kendone
 */
var util = (function () {

    var SIZE = {
        B: 1024,
        KB: 1048576,
        MB: 1073741824,
        GB: 1099511627776
    };

    return {
        sizeToStr: sizeToStr,
        getFilePostfix: getFilePostfix,
        getFileName: getFileName
    };

    function getFileName(fileName) {
        if (!fileName || !/(\\+)$/.test(fileName)) {
            throw new Error("File name is invalid");
        }
        fileName = fileName.split("/");
        return fileName[fileName.length - 1];
    }

    function getFilePostfix(fileName) {
        if (!fileName) {
            throw new Error("file name must not be null");
        }
        fileName = fileName.split(".");
        return fileName[fileName.length - 1];
    }

    function sizeToStr(fileSize) {
        var fileSizeStr;

        fileSize = parseFloat(fileSize);
        if (isNaN(fileSize)) return "";
        if (fileSize < SIZE.B) {
            fileSizeStr = fileSize.toFixed(2) + "B";
        } else if (fileSize < SIZE.KB) {
            fileSizeStr = (fileSize / SIZE.KB).toFixed(2) + "KB";
        } else if (fileSize < SIZE.MB) {
            fileSizeStr = (fileSize / SIZE.MB).toFixed(2) + "MB";
        } else if (fileSize < SIZE.GB) {
            fileSizeStr = (fileSize / SIZE.GB).toFixed(2) + "GB";
        }

        return fileSizeStr;
    }
})();