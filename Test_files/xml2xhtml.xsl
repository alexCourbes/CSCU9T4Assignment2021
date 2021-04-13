<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:key name="citByJournal" match="cit[@type='JournalCitation']" use="journal"/>
    <xsl:key name="citByJournalPublisher" match="cit[@type='JournalCitation']" use="publisher"/>
    <xsl:key name="citByVenue" match="cit[@type='ConferenceCitation']" use="venue"/>
    <xsl:key name="citByLocation" match="cit[@type='ConferenceCitation']" use="location"/>
    <xsl:key name="citByBook" match="cit[@type='ConferenceBook']" use="book"/>
    <xsl:key name="citByBookPublisher" match="cit[@type='ConferenceBook']" use="publisher"/>
    <xsl:template match="/bibliography">
        <html>
            <body style="font-family:Arial;font-size:12pt;background-color:#EEEEEE">
                <h1>Bibliography summary</h1>
                <h2>Journal articles</h2>
                <ul>
                    <li>Number of journal articles</li>
                    <dd>
                        <xsl:value-of select="count(cit/journal) "/>
                    </dd>
                    <li>Most frequent journal</li>
                    <dd>
                        <xsl:for-each
                                select="cit[@type='JournalCitation'][count(generate-id() = generate-id(key('citByJournal', journal)[1]))]">
                            <xsl:sort select="cit[count(key('citByJournal', journal))]" data-type="number"
                                      order="descending"/>
                            <xsl:if test="position() = 1">
                                <xsl:value-of select="journal"/>
                            </xsl:if>
                        </xsl:for-each>
                    </dd>
                    <li>Most frequent Journal publisher</li>
                    <dd>
                        <xsl:for-each
                                select="cit[@type='JournalCitation'][count(generate-id() = generate-id(key('citByJournalPublisher', publisher)[1]))]">
                            <xsl:sort select="cit[count(key('citByJournalPublisher', publisher))]"
                                      data-type="number"
                                      order="descending"/>
                            <xsl:if test="position() = 1">
                                <xsl:value-of select="publisher"/>
                            </xsl:if>
                        </xsl:for-each>
                    </dd>
                </ul>
                <h2>Conference proceedings</h2>
                <ul>
                    <li>Number of conference proceedings</li>
                    <dd>
                        <xsl:value-of select="count(cit/venue)"/>
                    </dd>
                    <li>Most frequent venue</li>
                    <dd>
                        <xsl:for-each
                                select="cit[@type='ConferenceCitation'][count(generate-id() = generate-id(key('citByVenue', venue)[1]))]">
                            <xsl:sort select="cit[count(key('citByVenue', venue))]" data-type="number"
                                      order="descending"/>
                            <xsl:if test="position() = 1">
                                <xsl:value-of select="venue"/>
                            </xsl:if>
                        </xsl:for-each>
                    </dd>
                    <li>Most frequent location</li>
                    <dd>
                        <xsl:for-each
                                select="cit[@type='ConferenceCitation'][count(generate-id() = generate-id(key('citByLocation', location)[1]))]">
                            <xsl:sort select="cit[count(key('citByLocation', location))]" data-type="number"
                                      order="descending"/>
                            <xsl:if test="position() = 1">
                                <xsl:value-of select="location"/>
                            </xsl:if>
                        </xsl:for-each>
                    </dd>
                </ul>
                <h2>Book chapters</h2>
                <ul>
                    <li>Number of book chapters</li>
                    <dd>
                        <xsl:value-of select="count(cit/book)"/>
                    </dd>
                    <li>Most frequent book</li>
                    <dd>
                        <xsl:for-each
                                select="cit[@type='ConferenceBook'][count(generate-id() = generate-id(key('citByBook', book)[1]))]">
                            <xsl:sort select="cit[count(key('citByBook', book))]" data-type="number"
                                      order="descending"/>
                            <xsl:if test="position() = 1">
                                <xsl:value-of select="book"/>
                            </xsl:if>
                        </xsl:for-each>
                    </dd>
                    <li>Most frequent publisher</li>
                    <dd>
                        <xsl:for-each
                                select="cit[@type='ConferenceBook'][count(generate-id() = generate-id(key('citByBookPublisher', publisher)[1]))]">
                            <xsl:sort select="cit[count(key('citByBookPublisher', publisher))]" data-type="number"
                                      order="descending"/>
                            <xsl:if test="position() = 1">
                                <xsl:value-of select="publisher"/>
                            </xsl:if>
                        </xsl:for-each>
                    </dd>
                </ul>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>