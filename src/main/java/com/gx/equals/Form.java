package com.gx.equals;

import java.util.List;

/**
 * @author gx
 * @ClassName: Form
 * @Description: java类作用描述
 * @date 2019/3/9 3:45
 * @Version: 1.0
 * @since
 */
public class Form {


    private String device_id;
    private String timestamp;
    private String log_id;
    private String reserve_info;
    private List<DeviceDataBean> device_data;

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getLog_id() {
        return log_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    public String getReserve_info() {
        return reserve_info;
    }

    public void setReserve_info(String reserve_info) {
        this.reserve_info = reserve_info;
    }

    public List<DeviceDataBean> getDevice_data() {
        return device_data;
    }

    public void setDevice_data(List<DeviceDataBean> device_data) {
        this.device_data = device_data;
    }

    public static class DeviceDataBean {
        /**
         * device_id : 345
         * head_mode : 1
         * head_count : 2
         * panoramaData : {"panorama_id":"1","panorama_image":"1"}
         * roi_data : [{"roi_id":"1","head_count":4,"position":[{"x":1.2,"y":1.3}]}]
         * head_data : [{"roi_id":"1","x":1.1,"y":1.1,"width":100,"height":100,"direction":10,"speed":1,"detect_id":"1"}]
         */

        private String device_id;
        private int head_mode;
        private int head_count;
        private PanoramaDataBean panoramaData;
        private List<RoiDataBean> roi_data;
        private List<HeadDataBean> head_data;

        public String getDevice_id() {
            return device_id;
        }

        public void setDevice_id(String device_id) {
            this.device_id = device_id;
        }

        public int getHead_mode() {
            return head_mode;
        }

        public void setHead_mode(int head_mode) {
            this.head_mode = head_mode;
        }

        public int getHead_count() {
            return head_count;
        }

        public void setHead_count(int head_count) {
            this.head_count = head_count;
        }

        public PanoramaDataBean getPanoramaData() {
            return panoramaData;
        }

        public void setPanoramaData(PanoramaDataBean panoramaData) {
            this.panoramaData = panoramaData;
        }

        public List<RoiDataBean> getRoi_data() {
            return roi_data;
        }

        public void setRoi_data(List<RoiDataBean> roi_data) {
            this.roi_data = roi_data;
        }

        public List<HeadDataBean> getHead_data() {
            return head_data;
        }

        public void setHead_data(List<HeadDataBean> head_data) {
            this.head_data = head_data;
        }

        public static class PanoramaDataBean {
            /**
             * panorama_id : 1
             * panorama_image : 1
             */

            private String panorama_id;
            private String panorama_image;

            public String getPanorama_id() {
                return panorama_id;
            }

            public void setPanorama_id(String panorama_id) {
                this.panorama_id = panorama_id;
            }

            public String getPanorama_image() {
                return panorama_image;
            }

            public void setPanorama_image(String panorama_image) {
                this.panorama_image = panorama_image;
            }
        }

        public static class RoiDataBean {
            /**
             * roi_id : 1
             * head_count : 4
             * position : [{"x":1.2,"y":1.3}]
             */

            private String roi_id;
            private int head_count;
            private List<PositionBean> position;

            public String getRoi_id() {
                return roi_id;
            }

            public void setRoi_id(String roi_id) {
                this.roi_id = roi_id;
            }

            public int getHead_count() {
                return head_count;
            }

            public void setHead_count(int head_count) {
                this.head_count = head_count;
            }

            public List<PositionBean> getPosition() {
                return position;
            }

            public void setPosition(List<PositionBean> position) {
                this.position = position;
            }

            public static class PositionBean {
                /**
                 * x : 1.2
                 * y : 1.3
                 */

                private double x;
                private double y;

                public double getX() {
                    return x;
                }

                public void setX(double x) {
                    this.x = x;
                }

                public double getY() {
                    return y;
                }

                public void setY(double y) {
                    this.y = y;
                }
            }
        }

        public static class HeadDataBean {
            /**
             * roi_id : 1
             * x : 1.1
             * y : 1.1
             * width : 100
             * height : 100
             * direction : 10
             * speed : 1
             * detect_id : 1
             */

            private String roi_id;
            private double x;
            private double y;
            private int width;
            private int height;
            private int direction;
            private int speed;
            private String detect_id;

            public String getRoi_id() {
                return roi_id;
            }

            public void setRoi_id(String roi_id) {
                this.roi_id = roi_id;
            }

            public double getX() {
                return x;
            }

            public void setX(double x) {
                this.x = x;
            }

            public double getY() {
                return y;
            }

            public void setY(double y) {
                this.y = y;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getDirection() {
                return direction;
            }

            public void setDirection(int direction) {
                this.direction = direction;
            }

            public int getSpeed() {
                return speed;
            }

            public void setSpeed(int speed) {
                this.speed = speed;
            }

            public String getDetect_id() {
                return detect_id;
            }

            public void setDetect_id(String detect_id) {
                this.detect_id = detect_id;
            }
        }
    }
}
