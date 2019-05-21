(ns wh.logged-in.apply.db
  (:require
    [cljs.spec.alpha :as s]))

(def steps #{:name :cv-upload :thanks :current-location})

(s/def ::steps-taken (s/coll-of steps))
(s/def ::current-step steps)
(s/def ::id string?)
(s/def ::submit-success? boolean?)
(s/def ::updating? boolean?)
(s/def ::cv-upload-failed? boolean?)
(s/def ::name-update-failed? boolean?)
(s/def ::job (s/keys :req-un [::id]))

(s/def ::sub-db (s/keys :opt-un [::job
                                 ::submit-success?
                                 ::updating?
                                 ::current-step
                                 ::steps-taken
                                 ::name-update-failed?
                                 ::cv-upload-failed?]))

(def default-db {::steps-taken #{}})
